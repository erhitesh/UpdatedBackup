from selenium.webdriver.common.by import By
from realm.helpers import wait_element

def cnp_display(test, expected_caption):
    """ Steps to confirm correct CNP eCard is opened.
        @param test: Instance of test-case.
        
    """
    wait_element(test, By.ID, "agi-cardtitle")  
    test.assertTrue(expected_caption, test.browser.find_element_by_id("agi-cardtitle").text)