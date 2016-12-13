from .custompd import *
from .login import mail_login
from selenium.webdriver.common.by import By
from realm.helpers import wait_element

def greetingreceived(test, from_name):   
    """ Steps for checking whether card sent or not.
       @param test: Instance of test-case.
       
    """ 
    pickup_received = False
    
    wait_element(test, By.CLASS_NAME, "subject")
    emails_subjects = test.browser.find_elements_by_class_name("subject")
    for email in emails_subjects:
        subject = str(email.text)
        if subject.find(from_name) >= 0:
            pickup_received = True
            email.click()
            break
        
    if not pickup_received:
        test.assertFalse(True, "Error: Pickup eCard not received yet...")
               
def verify_pickup_ecard(test, notification, from_name):
    agi_send_ecard(test)
    verify_sends(test)
    mail_login(test)    
    if notification == 'none' or notification == 'notify_pickup':
        greetingreceived(test, from_name)        
    elif notification == 'send_copy':        
        view_send_card_copy(test, from_name)

def pickup_ecard(test, notification='none', add_photo = False):
    """ Steps for send ecard to users and pick up their ecards.
        @param test: Instance of test-case. 
        
    """
    if add_photo:
        # Selenium has no functionality to Image upload
        # Not Implemented.
        pass
    
    send_ecard_on_email(test)         
    add_recipient_information(test, pickup=True)
    from_name = add_sender_information(test, pickup=True)
    special_requests_notifications(test, notification)
    verify_pickup_ecard(test, notification, from_name)   
    
def view_send_card_copy(test, from_name):
    """ Steps for checking whether you card is viewable or not.
        @param test: Instance of test-case. 
        
    """
    greetingreceived(test, from_name)
    wait_element(test, By.XPATH, "//img[@alt='pickup your greeting']")
    test.browser.find_element_by_xpath("//img[@alt='pickup your greeting']").click()
    handle = test.browser.window_handles
    test.browser.switch_to.window(handle[1])