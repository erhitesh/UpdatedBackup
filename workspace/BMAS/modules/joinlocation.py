from selenium.webdriver.common.by import By
from realm.helpers import wait_element
from .cardselection import seach_ecard


def join_now_user(test):
    """ Join new user on bma.
        @param: Instance of realm.TestCase class.
    
    """
    wait_element(test, By.ID, "agi-join") 
    test.browser.find_element_by_id("agi-join").click()
    
def search_ecard(test, ecard):
	"""Search eCard on based on the"""
	wait_element(test, By.ID, "search")
	search_text = test.browser.find_element_by_id("search")
	search_text.send_keys(ecard)
	test.browser.find_element_by_name("btnsearch").click()    

def join_location(test, location):
	""" Steps to add a new customer based on location, if location
	is 'header' then it will click on join now link. Otherwise first
	of all select and personalize the card then join on site.
		@param test: Instance of test-case. 
		@param location: Where to join user on login or at card send.  
		
	"""
	ecard_path = "//img[@alt='Birthday Hoedown<br>Singing Telegram']"
	
	if location == "header":
		join_now_user(test)		
	elif location == "send":		
		search_ecard(test, ecard_path)		
		test.browser.find_element_by_xpath(ecard_path).click()
		test.browser.find_element_by_id("agi-signindisplay1").click()