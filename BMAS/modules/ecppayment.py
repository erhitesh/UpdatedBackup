from realm.data import ecp, cc

def ecp_payment(test):
    """ ecp_payment module enters account and routing details
    related to payment. 
        @param test: Instance of test-case.
        
    """
    test.browser.find_element_by_id("fli-paymethod-ecp").click()
    test.browser.find_element_by_id("_ecp_name").send_keys(ecp['account'])
    test.browser.find_element_by_id("_ecp_rtng_num").send_keys(ecp['routing'])
    test.browser.find_element_by_id("_ecp_acct_num").send_keys(cc['visa'])
    test.browser.find_element_by_id("submit-button").click()