from selenium.webdriver.common.by import By
from realm.helpers import wait_element, wait_for_expected_url
from selenium.webdriver.common.action_chains import ActionChains

def cnp_card_selection(test):
	""" Steps to select printable card.
		@param test: Instance of test-case. 

	"""
	action = ActionChains(test.browser)
	cnp_menu_link = test.browser.find_element_by_id("dd-printables")
	action.move_to_element(cnp_menu_link).double_click().perform()
	wait_for_expected_url(test, "http://www.bluemountain.com/printable-cards")	
	ecard_caption = test.browser.find_elements_by_xpath("//*[@id='docpane']/ol/li/div/div[2]/a")
	expected_caption = ecard_caption[0].text
	ecard_caption[0].click()
	
	return expected_caption
