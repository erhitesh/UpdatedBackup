from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from realm.helpers import wait_element

from realm.data import customer
from selenium.webdriver.support.select import Select
from realm.helpers import random_name, random_bday, random_month,\
     new_email, random_byear


def contacts(test):
    """Steps to add a new contact information. 
    	@param test: Instance of test-case.
    	@type test: Object 
    	
    """
    # Importing address from data file.
    city = customer['city']
    lastname =random_name(5)
    phone = customer['phone']
    firstname = random_name(7)
    address1 = customer['address1']	
    zip_value = customer['zip_code']
    
    wait_element(test, By.CLASS_NAME, "add-contact")
    test.browser.find_element_by_class_name("add-contact").click()
    test.browser.find_element_by_name("firstName").send_keys(firstname)	
    test.browser.find_element_by_name("email").send_keys(new_email())
    test.browser.find_element_by_name("address1").send_keys(address1)
    test.browser.find_element_by_name("city").send_keys(city)
    test.browser.find_element_by_name("zip").send_keys(zip_value)
    test.browser.find_element_by_name("phone").send_keys(phone)
    Select(test.browser.find_element_by_id('state')).select_by_visible_text(customer['state'])	
    Select(test.browser.find_element_by_id('month-B')).select_by_visible_text(random_month('Full'))	
    Select(test.browser.find_element_by_id('day-B')).select_by_visible_text(random_bday(2))	
    Select(test.browser.find_element_by_id('year-B')).select_by_visible_text(random_byear())
    # Submitting the form values!!
    test.browser.find_element_by_name("cmd_submit").click()