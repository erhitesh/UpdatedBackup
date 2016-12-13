from realm.helpers import new_email
from realm import data

def who_pd(test):
    """ Who_pd module used to add new email id for register
    a new user in the BMA site.
        @param test: Instance of testcase. 
        
    """
    #test.browser.find_element_by_id("fli-email").send_keys(new_email())
    test.browser.find_element_by_id("fli-email").send_keys(data.customer['new_email_address'])
    test.browser.find_element_by_id("fli-submit-button").click()