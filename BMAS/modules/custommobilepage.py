from realm.data import send_to
from selenium.webdriver.common.by import By
from realm.helpers import wait_text, wait_element

def add_message(test, message="hello! Tester"):
    """ Steps to add message in eCard.    
        @param test: Instance of test-case.
        @param message: Message to insert into eCard
        
    """ 
    wait_element(test, By.ID, "bma-msg-txt") 
    test.browser.find_element_by_id("bma-msg-txt").send_keys(message)
        
    return message

def custom_mobilepage(test): 
    """ Send text message on mobile.
        @param test: Instance of test-case.
        
    """ 
    add_message(test)   
    print "Mobile send functionality is no more supported by this website."    
#     test.browser.find_element_by_id("send-text").click()
#     wait_element(test, By.ID, "to_name")
#     test.browser.find_element_by_id("to_name").send_keys(send_to['to_name'])    
#     test.browser.find_element_by_id("to_number").send_keys(send_to['mobile'])
#     test.browser.find_element_by_id("agi-btnsend").click()