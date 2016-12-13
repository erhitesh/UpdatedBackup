import time
from selenium.webdriver.common.by import By
from realm.helpers import wait_text, wait_element

def myaccount_test(test, view_type):
    """ User can see your saved favorite ecards, sent ecard & received ecard. 
        @param test: Instance of test-case.
        
    """
    test.browser.find_element_by_link_text("My Account").click()
    time.sleep(5)
    if view_type == "favorites":
        test.browser.find_element_by_link_text("Favorites").click()
        wait_element(test, By.XPATH, "//span[@class='agi-bcend']")
        test.assertEqual("Favorites", test.browser.find_element_by_xpath("//span[@class='agi-bcend']").text)

    elif view_type == "gifts_sent":
        test.browser.find_element_by_link_text("eCards & Gifts Sent").click()
        wait_element(test, By.XPATH, "//span[@class='agi-bcend']")
        test.assertEqual("Greetings Sent", test.browser.find_element_by_xpath("//span[@class='agi-bcend']").text)
        
    elif view_type == "gifts_receive":
        test.browser.find_element_by_link_text("eCards & Gifts Received").click()
        wait_element(test, By.XPATH, "//span[@class='agi-bcend']")
        test.assertEqual("Greetings Received", test.browser.find_element_by_xpath("//span[@class='agi-bcend']").text)
        
    elif view_type == "settings_preferences":
        test.browser.find_element_by_link_text("Settings & Preferences").click()
        wait_element(test, By.XPATH, "//*[@class='memhead']//h2")
        test.browser.find_element_by_xpath("//input[@type='Checkbox']").click()
        test.browser.find_element_by_id("saveChanges").click()
        # uncheck
        test.browser.find_element_by_xpath("//input[@type='Checkbox']").click()
        test.browser.find_element_by_id("saveChanges").click()
        
    elif view_type == "view_settings":
        test.browser.find_element_by_link_text("Settings & Preferences").click()
        wait_element(test, By.XPATH, "//*[@class='memhead']//h2")
    