from selenium.webdriver.support.select import Select
from realm.data import cc_meta, cc

def cc_payment(test, payment):
    """Steps for process payment during add a new user.   
		@param test: Instance of selenium object.
		@param payment: Type of payment options.
		@type payment: String  
		
    """
    card_name = cc["passthru"] # cc_meta['name'] 
    card_number = 'xxxxxxx' #cc[payment] 
    exp_month = cc_meta['exp_month']
    exp_year = cc_meta['exp_year']
    cc_code = cc_meta['amex_code'] if payment == 'amex' else cc_meta['code'] 
	
    ccname_text = test.browser.find_element_by_id("_cc_name")
    ccname_text.send_keys(card_name)
    test.assertEqual(card_name, ccname_text.get_attribute("value"))	
    ccnumber_text = test.browser.find_element_by_id("_cc_num")
    ccnumber_text.send_keys(card_number)
    test.assertEqual(card_number, ccnumber_text.get_attribute("value"))	
    security_code_text = test.browser.find_element_by_id("_cvv2")	
    security_code_text.send_keys(cc_code)
    test.assertEqual(cc_code, security_code_text.get_attribute("value"))		
    exp_month_select = Select(test.browser.find_element_by_id('fli-_cc_exp_month'))
    exp_month_select.select_by_value(exp_month)
    exp_year_select = Select(test.browser.find_element_by_id('fli-_cc_exp_year'))
    exp_year_select.select_by_value(exp_year)
    test.browser.find_element_by_id("submit-button").click()
