from realm.helpers import wait_element
from selenium.webdriver.common.by import By

def address_book(test):
    """ Steps to select address book link for logged In user.
        @param test: Instance of test-case. 
        @type test: object 
                
    """    
    # Wait for element to visible on page!!
    wait_element(test, By.LINK_TEXT, "Address Book")
    test.browser.find_element_by_link_text("Address Book").click()