import time
from realm.data import send_to
from realm.helpers import wait_text, wait_element
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from realm.helpers import new_email, random_name,\
     random_month, random_bday, random_byear

def wallpaper_preview(test, wallpaper='Download'):
    """ Steps to preview free wallpaper & download wallpaper using registr free user(rfu). 
        @param test: Instance of test-case.
        @param wallpaper: Download or preview.
        
    """
    if wallpaper == 'Download':
        wall_screen(test)
        # For window handling.
        handle = test.browser.window_handles
        print "handle", handle
        test.browser.switch_to.window(handle[1])
        # Verifing url
        cur_url = test.browser.current_url
        sub_url = "wallpapers/card"
        value = cur_url.find(sub_url)
        test.assertTrue(value != -1, "Not Match Url data.")
        img_src = test.browser.find_element_by_xpath("//html/body/p/img")
        source = img_src.get_attribute("src")
        print source

    
    elif wallpaper == 'Preview':
        wall_screen(test)
        register_free_user(test)
          
    elif wallpaper == 'Reminder':
        test.browser.find_element_by_link_text("Reminders").click()
        test.browser.find_element_by_css_selector(".agi-button>a>img").click()
        register_free_user(test)
   
   
   
def register_free_user(test):
    test.browser.find_element_by_id("fli-email").clear()
    test.browser.find_element_by_id("fli-email").send_keys(new_email())
    # Click on get started button.
    test.browser.find_element_by_id("fli-submit-button").click()
    wait_element(test, By.ID, "first_name")
    # Enter First name
    test.browser.find_element_by_id("first_name").clear()
    test.browser.find_element_by_id("first_name").send_keys(random_name(10))
    test.browser.find_element_by_id("last_name").clear()
    test.browser.find_element_by_id("last_name").send_keys("jonny")
    test.browser.find_element_by_id("password").clear()
    test.browser.find_element_by_id("password").send_keys(send_to['random_pass'])
    test.browser.find_element_by_id("password_confirm").clear()
    test.browser.find_element_by_id("password_confirm").send_keys(send_to['random_pass'])
    # DOB(Date of birth)
    time.sleep(3)
    wait_element(test, By.ID, "month")
    Select(test.browser.find_element_by_id("month")).select_by_visible_text(random_month('num'))
    Select(test.browser.find_element_by_id("day")).select_by_index(random_bday(01))
    Select(test.browser.find_element_by_id("year")).select_by_visible_text(random_byear())
    # Click on register button.
    test.browser.find_element_by_id("fli-submit_button").click()
    wait_element(test, By.TAG_NAME, "h1")
    # Click on continue button.
    test.browser.find_element_by_link_text("Continue").click()
        
        
def wall_screen(test):
    test.browser.find_element_by_link_text("Free Downloads").click()
    # Click on any wallpaper .
    test.browser.find_element_by_xpath("//*[@id='small-thumb-3284950']").click()
    # wait for some moments.
    wait_text(test, "Wallpapers")
    # Click on Download button.
    test.browser.find_element_by_xpath("//img[@alt='Download Now']").click()
    time.sleep(3)
    
        