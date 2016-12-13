import time
from datetime import datetime
from selenium.webdriver.support.select import Select
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

from realm.data import cc, cc_meta, customer, send_to, pickup_account
from realm.helpers import wait_text, browser_exception, new_email, \
     wait_element, current_date, random_name

#-------------------------Custom1 and Custom2 page functions-------------------------------#

def send_ecard_on_email(test):
    """ Submit the eCard send button."""
    wait_element(test, By.ID, "agi-preview") 
    test.browser.find_element_by_id("agi-preview").click()
    
def preview_card(test):
    """ Automate the process of preview of a card."""
    wait_element(test, By.ID, "preview_button") 
    test.browser.find_element_by_id("preview_button").click()  
   
def preview_pane_close(test):
    """ Automate the process to close preview pane.""" 
    test.browser.find_element_by_id("closewindow").click()
    
def add_recipient_information(test, pickup=False):
    """Adding recipient name and email.
       @param pickup: Adding default or pickup user from data file.
    
    """ 
    to_name = pickup_account['name'] if pickup else send_to['to_name']
    to_email = pickup_account['email'] if pickup else send_to['recipient']

    wait_element(test, By.ID, "toname1")
    test.browser.find_element_by_id("toname1").send_keys(to_name) 
    test.browser.find_element_by_id("toemail1").send_keys(to_email) 

def add_sender_information(test, pickup=True):
    """Adding sender name and email."""
    if pickup:
        name = random_name(25)
        from_name_text = test.browser.find_element_by_name("fromname1")
        from_name_text.clear()
        from_name_text.send_keys(name) 
        return name
    else:
        test.browser.find_element_by_id("fromname1").send_keys(send_to['from_name'])
        test.browser.find_element_by_id("fromemail1").send_keys(send_to['sender'])

def select_notifications(test, *locators):
    """Select special requests with eCard."""
    for id in locators:
        checkbox = test.browser.find_element_by_id(id)
        if not checkbox.is_selected(): checkbox.click() 
        
def unselect_notifications(test, *locators):
    """Un-select special requests with eCard."""
    for id in locators:
        notification_checkbox = test.browser.find_element_by_id(id)
        if notification_checkbox.is_selected(): notification_checkbox.click()        
    
def special_requests_notifications(test, notification):
    """Adding special requests with eCard.
       @param notification: Selecting the special notifications.
    
    """         
    unselect_notifications(test, "cc_sender", "reply_request", "notify_nopickup")
    
    if notification == 'all':
        select_notifications(test, "cc_sender", "reply_request", "notify_nopickup")
    elif notification == 'send_copy':
        select_notifications(test, "cc_sender")
    elif notification == 'notify_pickup':
        select_notifications(test, "reply_request")
                
def agi_send_ecard(test):
    """Submit the send button.""" 
    # eCard send!!
    test.browser.find_element_by_id("agi-send").click()
        
def future_date(test):
    """ User select future date .
        @param test: Instance of test case. 
    """
    wait_element(test, By.ID, "calanchor")    # for future date
    test.browser.find_element_by_id("calanchor").click()
    # for window handle
    handle = test.browser.window_handles
    test.browser.switch_to.window(handle[1])
    wait_element(test, By.CSS_SELECTOR, "a.cpMonthNavigation")
    test.browser.find_elements_by_css_selector("a.cpMonthNavigation")[1].click()
    time.sleep(1)
    # particular date selection
    test.browser.find_element_by_xpath("//*[@id='calendar']/center/table[2]/tbody/tr[3]/td[1]/a").click()
    # back to original Window
    test.browser.switch_to.window(handle[0])       

#----------------------------RTE Message Functions-------------------------------#   
 
def verify_suggested_message(test, selected_message):
    """ Verify eCard suggested message functionality on Rich text box
        on custom page one.    
        @param selected_message: Message to add.
        
    """ 
    preview_card(test) 
    wait_element(test, By.XPATH, "//div[@id='product_msg_element']/p") 
    messagebox_text = test.browser.find_element_by_xpath("//div[@id='product_msg_element']/p")
    # Get the entered text from RTE and verify.    
    personalized_message = messagebox_text.get_attribute("innerHTML").strip()
    test.assertEquals("[MESSAGE]: " + personalized_message, "[MESSAGE]: " + selected_message)
    preview_pane_close(test)
      
def add_suggested_message(test):
    """ verify eCard suggested message functionality on Rich text box.""" 
    
    message_type = ":birthday"
    
    test.browser.find_element_by_xpath("//div[@class='suggestmessage text non-mobile']/a").click() 
    # Create a handle for suggest message window popup.
    handle = test.browser.window_handles
    test.browser.switch_to_window(handle[1])
    # Test suggest message popup is open or not!
    test.assertEqual("BlueMountain.com- Suggested Messages", test.browser.title)
    wait_text(test, "Suggested Messages")
    # Choose message category form drop-down.
    Select(test.browser.find_element_by_xpath("//select[@name='cat']")).select_by_value(message_type)
    messagebox_text = test.browser.find_element_by_xpath("//div[@id='agi-page']/div[4]/table/tbody/tr[2]/td/input")
    message = messagebox_text.get_attribute("value") 
    # Select messages by select check-box!
    test.browser.find_element_by_xpath("//div[@id='agi-page']/div[4]/table/tbody/tr[2]/td/input").click() 
    test.browser.find_element_by_xpath("//a[.='Add to Greeting']").click() 
    test.browser.switch_to_window(handle[0])
    
    return message

def message_font(test, selected_font):
    """ verify font type size change functionality on RTE box.    
        @param selected_font: Type of font to customize eCard message.
        
    """ 
    card_message = add_message(test)
    Select(test.browser.find_element_by_name('pn1607')).select_by_value(selected_font)
    messagebox_text = test.browser.find_element_by_id("bma-msg-txt")
    elem_style = messagebox_text.get_attribute("style")     
    # Verifying the font changes applied or not.
    if elem_style.find(selected_font) < 0:
        test.assertTrue(False, "Error: Selected font is not applied on message.")    
        
    verify_suggested_message(test, card_message)
    
def increase_font_size(test):
    """Verify increase font size change functionality on RTE box.""" 
    for i in range(1, 7):
        test.browser.find_element_by_xpath("//img[@alt='Bigger']/..").click() 

def decrease_font_size(test):
    """Verify decrease font size change functionality on RTE box.""" 
    for i in range(1, 4):
        test.browser.find_element_by_xpath("//img[@alt='Smaller']/..").click() 

def verify_font_size(test, command):
    """ Verify font size change functionality on RTE box.    
        @param command: Font increase and decrease function. 
        
    """ 
    expected_font_size = "44px"
    
    # Add a message to e-card.
    add_message(test)
    increase_font_size(test)
    if command == "MIN":
        decrease_font_size(test)
        expected_font_size = "29px"

    actual_font_size = test.browser.execute_script("window.document.getElementById('bma-msg-txt').style.fontSize")
    if actual_font_size == expected_font_size:
        test.assertTrue(False, "Error: Font increase function not working properly.")
          
    preview_card(test)   
    message_label = test.browser.find_element_by_xpath("//*[@id='product_msg_element']/p")
    elem_style = message_label.get_attribute("style") 
    expected_font_size = "font-size: " + expected_font_size
    if elem_style.find(expected_font_size) < 0:
        test.assertTrue(False, "Error: Font increase function not working properly at preview.")
        
    preview_pane_close(test)        

def change_font_style(test):
    """ Change the font style. """ 
    test.browser.find_element_by_name("pn1608").click()
    test.browser.find_element_by_name("pn1609").click()
     
def verify_font_style(test):
    """ verify font style change functionality on RTE box. """ 
    
    expected_font_weight = "font-weight: bold"
    expected_font_style = "font-style: italic"
    
    # Add a message to e-card.
    add_message(test)
    change_font_style(test)
    message_label = test.browser.find_element_by_id("bma-msg-txt")
    elem_style = message_label.get_attribute("style") 
    if elem_style.find(expected_font_weight) < 0:
        test.assertTrue(False, "Error: Font Bold property not working.")
    
    if elem_style.find(expected_font_style) < 0:
        test.assertTrue(False, "Error: Font Italic property not working.")
    
    # View the preview of selected eCard and verify.    
    preview_card(test)
    messagebox_text = test.browser.find_element_by_xpath("//div[@id='product_msg_element']/p")
    elem_style = messagebox_text.get_attribute("style") 
    if elem_style.find(expected_font_weight) < 0:
        test.assertTrue(False, "Error: Font Bold property not working on preview.")
    
    if elem_style.find(expected_font_style) < 0:
        test.assertTrue(False, "Error: Font Italic property not working on preview.")   
        
    preview_pane_close(test)    

def verify_font_color(test):
    """ verify font color change functionality on RTE box. 
    """ 
    expected_font_color = "color: green"

    # Add a message to e-card.
    add_message(test)
    test.browser.find_element_by_id("color-select").click()
    test.browser.find_element_by_xpath("//div[@id='color-swatches']/div[5]/div/a/img").click()
    elem = test.browser.find_element_by_id("bma-msg-txt")
    elem_style = elem.get_attribute("style")
    if elem_style.find(expected_font_color) < 0:
        test.assertTrue(False, "Error: Font Color property not working.")
        
    # View the preview of selected eCard and verify.      
    preview_card(test)
    elem = test.browser.find_element_by_xpath("//div[@id='product_msg_element']/p")
    # Get the style property of element and verify color property.
    elem_style = elem.get_attribute("style")
    if elem_style.find(expected_font_color) < 0:
        test.assertTrue(False, "Error: Font Color property, not working on preview.")
        
    preview_pane_close(test)   

def spell_checker(test):
    """ Test the functionality of spell check for browsers.    
        @param test: Instance of test-case.
        
    """ 
    expected_alert_message = "Text area is empty!"
    
    # browser_exception function return the running browser name.
    if browser_exception(test) == 'MSIE':
        # Enable spell check functionality for IE browser!
        test.browser.find_element_by_xpath("//div[@id='spellcheck']/a").click()
        alert_box = test.browser.switch_to_alert()
        alert_message = alert_box.text
        test.assertEquals(alert_message, expected_alert_message)
        elem = test.browser.find_element_by_name("pn1465")
        elem.send_keys("Helloo Tester!")
    else:
        # Spell check functionality only applicable for IE browser.
        test.assertTrue(True, 'Note: Spell Check link funcionality applicable only for IE')

def verify_special_text_message(test, message_text):
    """ verify special characters on message box.    
        @param test: Instance of test-case.
        @param message_text: Message on RTE box.
        
    """ 
    messagebox_text = test.browser.find_element_by_id("bma-msg-txt")
    messagebox_text.clear()
    messagebox_text.send_keys(message_text)
    # View the preview of selected eCard and verify.    
    preview_card(test)
    # Get RTE text and verify changes.
    message_label = test.browser.find_elements_by_xpath("//div[@id='product_msg_element']/p")
    # Check for missing message label if the blank message.  
    if message_text == '' and message_label.__len__() == 0:
        return
    message_on_preview = message_label[0].get_attribute("innerHTML")
    test.assertEquals('[MESSAGE ON PREVIEW]: ' + message_on_preview, '[MESSAGE ON PREVIEW]: ' + message_text)
    preview_pane_close(test)
    elem = test.browser.find_element_by_xpath("//div[@id='product_msg_element']/p")
    personalized_essage = elem.get_attribute("innerHTML")
    test.assertEquals('[MESSAGE ON PREVIEW]: ' + personalized_essage, '[MESSAGE ON PREVIEW]: ' + message_text)
    
def urls_as_message_text(test, url):
    """ Verify Url string in message box of eCard.    
        @param test: Instance of test-case.
        @param url: URL as message on RTE box.
        
    """ 
    error_message = "We're sorry you're having trouble sending this. To prevent the misuse of our Blue Mountain site for spam scams, it's necessary to block the use of URLs and certain word combinations within the message. Please reword your message and continue."
   
    test.browser.find_element_by_id("bma-msg-txt").send_keys(url)
    send_ecard_on_email(test)
    wait_text(test, error_message)
    test.browser.execute_script("window.document.getElementById('bma-msg-txt').innerHTML=''") 
 
def apply_all_rte_tools(test):
    """ Steps to use set all properties in eCard.    
        @param test: Instance of test-case.
        
    """ 
    selected_font = "Courier"
    # Apply tools
    select = Select(test.browser.find_element_by_name('pn1607'))
    select.select_by_value(selected_font)
    # Increase Font size.
    test.browser.find_element_by_xpath("//img[@alt='Bigger']").click()
    # Decrease Font size.
    test.browser.find_element_by_xpath("//img[@alt='Smaller']").click()
    # Select font bold and itelic function.
    change_font_style(test)
    test.browser.find_element_by_id("color-select").click()
    time.sleep(1)
    test.browser.find_element_by_xpath("//div[@id='color-swatches']/div[5]/div/a/img").click()

def edit_message(test):
    """ Steps to edit eCard message.    
        @param test: Instance of test-case.
        
    """ 
    # Expected style properties after apply tools.
    selected_font = "Courier"
    font_size = "font-size: 14"
    expected_font_weight = "font-weight: bold"
    expected_font_style = "font-style: italic"
    expected_font_color = "color: green"

    # View the preview of selected eCard and verify.    
    preview_card(test)
    preview_pane_close(test)
    send_ecard_on_email(test) 
    # Back to Custom Page 1 by click on EditMessage button.
    wait_element(test, By.ID, "agi-editmessage")
    test.browser.find_element_by_id("agi-editmessage").click()
    elem = test.browser.find_element_by_id("bma-msg-txt")
    elem_style = elem.get_attribute("style")
    # Verify style properties.
    if elem_style.find(selected_font) < 0:
        test.assertTrue(False, "Error: Selected font is not applied on message.")        
    if elem_style.find(font_size) < 0:
        test.assertTrue(False, "Error: Font increase function not working properly")        
    if elem_style.find(expected_font_weight) < 0:
        test.assertTrue(False, "Error: Font Bold property not working.")           
    if elem_style.find(expected_font_style) < 0:
        test.assertTrue(False, "Error: Font Italic property not working.") 
    if elem_style.find(expected_font_color) < 0:
        test.assertTrue(False, "Error: Font Color property not working.")        
        
def add_message(test, message="hello! Tester"):
    """ Steps to add message in eCard.    
        @param test: Instance of test-case.
        @param message: Message to insert into eCard
        
    """ 
    test.browser.find_element_by_id("bma-msg-txt").clear()
    test.browser.find_element_by_id("bma-msg-txt").send_keys(message)
        
    return message

def add_photo(test):
    """ Upload an image in eCard from file system.    
        @param test: Instance of test-case.
        
    """ 
    test.browser.find_element_by_xpath("//input[@value='Add a Photo']").click()

#------------------------------------------------Sends-----------------------------------------------#    
def verify_sends(test):
    """Verify the sends.""" 
    # Test success message on page!
    wait_text(test, "Sent!")
    
def send_ecard(test, option='none'):
    """ Steps to automate eCard send functionality on Rich text box
        on custom page one.    
        @param test: Instance of test-case.
        
    """ 
    send_ecard_on_email(test)         
    add_recipient_information(test) 
    if option == 'future':
        future_date(test)      
    elif option == 'special':
        special_request_notification(test)    
    elif option == 'personal':
        add_personal_reminder(test)
                          
    special_requests_notifications(test, notification='none')    
    agi_send_ecard(test)
    verify_sends(test)
    
def custompd(test, operation, account):
    """ Verify eCard suggested message functionality on Rich text box
        on custom page one.    
        @param test: Instance of test-case.
        @param operation: Preview the eCard before send or directly send it to someone. 
        @param account: Type of user account ex. mcp, afu and rfu.  
        
    """ 
    if operation == "preview":
        preview_card(test)
        preview_pane_close(test)
    elif operation == "giftsend":
        test.browser.find_element_by_id("add_a_gift").click()
    elif operation == "print":
        send_ecard_on_email(test) 
        test.browser.find_element_by_id("print_button").click()
        return        
     
    (test)         
    add_recipient_information(test)    
    if account == "afu":      
        add_sender_information(test)        
    elif account == "rfu" or account == "mcp":  
        test.browser.find_element_by_id("add_address").click()
 
    special_requests_notifications(test, notification='all')
    agi_send_ecard(test)
    if operation == "giftsend":
        select_marchant(test)
        cc_gift_payment(test)          
    else:    
        verify_sends(test)      
#-------------------------------------------Add Reminder eCard---------------------------------------#
def personal_reminder_on_calendar(test):
    """Steps back to home page.
        @param self: Instance of SeleniumTestScript class.

    """
    reminder_added = False
    formatted_current_date = current_date("%Y%m%d")
    expected_calendar_image = "//*[@id='td"+formatted_current_date+"']/p/a"
    
    # navigate to home page
    test.browser.find_element_by_link_text("Home").click()
    wait_element(test, By.CSS_SELECTOR, "div > a > span") 
    test.browser.find_element_by_css_selector("div > a > span").click()
    # wait for some moments
    wait_element(test, By.XPATH, "//div[@id='agi-calhead']/div[2]/span[1]") 
    reminders_images = test.browser.find_elements_by_xpath(expected_calendar_image)
    for reminder in reminders_images:
        reminder_text = reminder.get_attribute('text')
        if reminder_text.find(send_to['to_name']) >= 0:
            reminder_added = True
            reminder.click()
            wait_element(test, By.ID, "agi-poptitle") 
            break  
            
    if not reminder_added:
        test.assertTrue(False, "Error: Reminder not added successfully...")   
    
def add_personal_reminder(test):
    """ Select Personal Reminders.
        @param : Instance of test-case.
        
    """
    wait_element(test, By.ID, "add_rem")  
    personal_reminder_checkbox = test.browser.find_element_by_id("add_rem")
    if not personal_reminder_checkbox.is_selected():
        personal_reminder_checkbox.click() 
    
    reminder_date = Select(test.browser.find_element_by_id('remday'))
    reminder_date.select_by_index(0)
    #reminder_date.select_by_visible_text("20")
     

#-------------------------------------------Custom Address Book--------------------------------------#   
    
def custom_address_book(test):
    """ Steps to select address book link to send card to other user.
        @param test: Instance of test-case. 
        @type test: object 
                     
    """
    test.browser.find_element_by_id("agi-preview").click()
    # address book functionality
    select_contact_checkboxes(test)
    # add recipients
    test.browser.find_element_by_css_selector(".agi-button-copy")
    test.browser.find_element_by_id("agi-send").click()  
    
def select_contact_checkboxes(test, view="contact"):
    """ Selecting a contact fron contact popup.
        @param : Instance of test-case. 
    """
    contact_view(test)
    
    if view == "group":
        group_view(test)
    else:
        contact_view(test)
        
    address_details = test.browser.find_elements_by_css_selector("table.inner-table>tbody>tr>td>input")
    address_details[0].click()
    test.assertTrue(address_details[0].is_selected(), "Error: Check box not selected....") 
    
def contact_view(test):
    """Select contact link from the custom page address popup.
       @param : Instance of test-case.
    
    """
    # for address book popup
    address_book_popup(test)
    # Select contact link from the address book popup.
    wait_element(test, By.CSS_SELECTOR, "div.view-select>span>span")  
    contact_link = test.browser.find_elements_by_css_selector("div.view-select>span>span")
    contact_link[0].click()   
    
def address_book_popup(test):
    """ Steps to select address book link for logged In user.
        @param test: Instance of test-case. 
        @type test: object 
                     
    """    
    # Wait for element to visible on page!!
    wait_element(test, By.LINK_TEXT, "Open Address Book")
    test.browser.find_element_by_link_text("Open Address Book").click()   
    
#-------------------------------------------Adding Gift eCard---------------------------------#
    
def cc_gift_payment(test):
    """Adding the personal and payment information.""" 
    email = customer['new_email_address']      
    
    test.browser.switch_to_frame(2) 
    test.browser.find_element_by_id("CreditCardNumber").send_keys(cc["passthru"])
    test.browser.find_element_by_id("CreditCardIdNumber").send_keys(cc_meta['code'])
    test.browser.find_element_by_id("BillingFirstName").send_keys(customer['fname'])
    test.browser.find_element_by_id("BillingLastName").send_keys(customer['lname'])
    test.browser.find_element_by_id("Address").send_keys(customer['address1'])
    test.browser.find_element_by_id("City").send_keys(customer['city'])
    test.browser.find_element_by_id("ZipCode").send_keys(customer['zip_code'])
    test.browser.find_element_by_id("PhoneNumber").send_keys(customer['phone']) 
    test.browser.find_element_by_id("Email").send_keys(email) 
    test.browser.find_element_by_id("EmailConfirm").send_keys(email)         
    exp_year_select = Select(test.browser.find_element_by_id('ExpirationYear'))
    exp_year_select.select_by_visible_text(cc_meta['exp_year'])        
    exp_month_select = Select(test.browser.find_element_by_id('StateProvince'))
    exp_month_select.select_by_visible_text("Ohio")        

def select_marchant(test):
    """Select the marchant based on denomination and Categories filter.""" 
    wait_text(test, "Add a Gift Card to your Greeting")
    test.browser.find_element_by_id("ck-giftangogiftcard").click()
    test.browser.switch_to_frame(1)
    wait_element(test, By.XPATH, "//*[@id='DenominationsFilterHeader']/div")
    test.browser.find_element_by_xpath("//*[@id='DenominationsFilterHeader']/div").click()
    wait_element(test, By.XPATH, "//*[@id='Denominations']/li[3]")
    test.browser.find_element_by_xpath("//*[@id='Denominations']/li[3]").click() 
    wait_element(test, By.XPATH, "//*[@id='CategoriesFilterHeader']/div")
    test.browser.find_element_by_xpath("//*[@id='CategoriesFilterHeader']/div").click()
    time.sleep(1)
    wait_element(test, By.XPATH, "//*[@id='Categories']/li[2]")
    test.browser.find_element_by_xpath("//*[@id='Categories']/li[2]").click()
    wait_element(test, By.XPATH, "//*[@id='MerchantList']/li[1]/img")
    test.browser.find_element_by_xpath("//*[@id='MerchantList']/li[1]/img").click()
    test.browser.find_element_by_id("AddCardButton").click()
    test.browser.switch_to_default_content()
    test.browser.find_element_by_id("agi-btnsend").click()              