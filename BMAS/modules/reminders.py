from realm.helpers import wait_text, wait_element
from selenium.webdriver.common.by import By
from .orderpd import create_free_account     

def reminder_select(test):
    """ Steps to select reminder.
        @param test: Instance of test-case.
        
    """
    wait_element(test, By.LINK_TEXT, "Reminders")
    test.browser.find_element_by_link_text("Reminders").click()
    test.browser.find_element_by_css_selector(".agi-button>a>img").click()
    create_free_account(test)        

    
        