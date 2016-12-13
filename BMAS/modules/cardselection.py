from selenium.webdriver.common.by import By
from realm.helpers import wait_element

def select_stationery_card(test):
    """ User select message from suggested message link.
        @param test: Instance of test case. 
        
    """
    wait_element(test, By.XPATH, "//*[@id='bma-nav']/li[4]/a")    
    test.browser.find_element_by_xpath("//*[@id='bma-nav']/li[4]/a").click()
    # select stationery eCard!!
    wait_element(test, By.ID, "small-thumb-3337897") 
    test.browser.find_element_by_id("small-thumb-3337897").click()

def seach_ecard(test, ecard):
	""" Search eCard on based on the """
	wait_element(test, By.ID, "search")
	search_text = test.browser.find_element_by_id("search")
	search_text.send_keys(ecard)
	test.browser.find_element_by_name("btnsearch").click()

def personalize_send(test):
	"""Select the personalize the send button
	   @param test: Instance of test-case. 
	
	"""
	# personalize the eCard.	
	wait_element(test, By.XPATH, "//*[@id='display-buttons-bottom']//*[1]")
	test.browser.find_element_by_xpath("//*[@id='display-buttons-bottom']//*[1]").click()

def select_ecard_based_on_type(test, ecard_type):	
	""" Select eCards based on type of user account.	
		@param test: Instance of test-case. 
		@param ecard_type: eCard Type. 	
			
	"""			
	if ecard_type == 'free':
		return "Sea of Thanks Thank You eCards"
	elif ecard_type == 'paid':
		return "birthday hoedown"
	elif ecard_type == 'talking':
		return "Feliz Navidog!"
	elif ecard_type == 'postcard':
		return "Happy Kwanzaa"
	elif ecard_type == 'stationery':
		select_stationery_card(test)
		
def card_selection(test, account, ecard_type='paid'):
	""" Select eCards based on type of user account.	
		@param test: Instance of test-case. 
		@param account: Type of user account. 	
		@param ecard_type: Type of eCard.
			
	"""		
	ecard = select_ecard_based_on_type(test, ecard_type)	
	if ecard_type != 'stationery':
		# Select a eCard using search function!! 
		seach_ecard(test, ecard)
		wait_element(test, By.XPATH, "//ul[@id='t-thumbs']//li[1]//a[1]")
		test.browser.find_element_by_xpath("//ul[@id='t-thumbs']//li[1]//a[1]").click()		
		
	personalize_send(test)