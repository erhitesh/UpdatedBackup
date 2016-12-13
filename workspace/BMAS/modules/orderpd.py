import time
from selenium.webdriver.common.by import By
from realm.helpers import wait_element

from realm.data import customer
from realm.helpers import random_month, random_bday, random_byear,\
     wait_text
from selenium.webdriver.support.select import Select
from .whopd import who_pd
from selenium.common.exceptions import ElementNotVisibleException

def personal_information(test):
    """ Steps to enter personal information of user.
        @param test: Instance of test-case.

    """    
    wait_element(test, By.ID, "first_name")
    test.browser.find_element_by_id("first_name").send_keys(customer['fname'])
    test.browser.find_element_by_id("last_name").send_keys(customer['lname'])    
    test.browser.find_element_by_id("password").send_keys(customer['pswd'])        
    test.browser.find_element_by_id("password_confirm").send_keys(customer['pswd'])
    birthday_month = Select(test.browser.find_element_by_id('month')) 
    month = random_month('Num') if birthday_month.options[1].text != 'January' else random_month('full')
    birthday_month.select_by_visible_text(month)
    Select(test.browser.find_element_by_id('day')).select_by_visible_text(random_bday(2))   
    birthday_year = test.browser.find_elements_by_name('year')
    if birthday_year.__len__()> 0 and birthday_year[0].is_displayed():
        Select(test.browser.find_element_by_id('year')).select_by_visible_text(random_byear())
            
def address_information(test):
    test.browser.find_element_by_id("street_address_1").send_keys(customer['address1'])    
    test.browser.find_element_by_id("city").send_keys(customer['city'])    
    Select(test.browser.find_element_by_id('state')).select_by_visible_text(customer['state'])    
    test.browser.find_element_by_id("zip_code").send_keys(customer['zip_code']) 

def contact_information(test):
    phone_no = test.browser.find_elements_by_name("phone_number")
    if phone_no.__len__()> 0 and phone_no[0].is_displayed():
        phone_no[1].send_keys(customer['phone'])

def subscription_selection(test, subscription):
    if subscription == "year":
        test.browser.execute_script("document.getElementById('bhz31758').click();")
    elif subscription == "month":
        test.browser.execute_script("document.getElementById('bhz31760').click();")

def order_pd(test, subscription):
    """ Steps to insert basic and address information of user.
        @param test: Instance of test-case. 
        @param subscription: Duration of membership.

    """
    personal_information(test)
    contact_information(test)
    subscription_selection(test, subscription)
    address_information(test)

def submit_registration(test):
    test.browser.find_element_by_id("fli-submit_button").click()
    wait_text(test, "Thanks for Registering!")

def continue_shopping(test):
    test.browser.find_element_by_link_text("Continue").click()    

def create_free_account(test):
    who_pd(test)
    personal_information(test)
    submit_registration(test)
    continue_shopping(test)