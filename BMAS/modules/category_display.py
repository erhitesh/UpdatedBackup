import time
from realm.helpers import wait_element, wait_for_expected_url
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains


def ecard_display(test):
    """Steps to verify user can view the eCards page.   
        @param test: Instance of selenium object.
        
    """
    action =  ActionChains(test.browser)
    action.double_click(test.browser.find_element_by_id("dd-ecards"))
    action.perform()
    expected_page_url = "http://www.bluemountain.com/ecards"
    wait_for_expected_url(test, expected_page_url)
    
def cnp_display(test):
    """Steps to verify user can view the cnp page.   
        @param test: Instance of selenium object.
        
    """

    action =  ActionChains(test.browser)
    #action.move_to_element(test.browser.find_element_by_class_name('ecards'))
    action.double_click(test.browser.find_element_by_id("dd-printables"))
    action.perform()  
    expected_page_url = "http://www.bluemountain.com/printable-cards"
    wait_for_expected_url(test, expected_page_url)
    
def birthday_display(test):
    """Steps to verify user can view the birthday page.   
        @param test: Instance of selenium object.
        
    """
    test.browser.find_element_by_xpath("//div[@id='test']/a[contains(text(), 'Birthday')]").click()
    expected_page_url = "http://www.bluemountain.com/ecards/birthday"
    wait_for_expected_url(test, expected_page_url)
    
def anniversary_display(test):
    """Steps to verify user can view the anniversary page.   
        @param test: Instance of selenium object.
        
    """
    test.browser.find_element_by_xpath("//div[@id='test']/a[contains(text(), 'Anniversary')]").click()
    expected_page_url = "http://www.bluemountain.com/ecards/anniversary"
    wait_for_expected_url(test, expected_page_url)
    
def talking_ecard_display(test):
    """Steps to verify user can view the talking eCards page.   
        @param test: Instance of selenium object.
        
    """
    test.browser.find_element_by_xpath("//div[@id='test']/a[contains(text(), 'Talking eCards')]").click()
    expected_page_url = "http://www.bluemountain.com/ecards/talking"
    wait_for_expected_url(test, expected_page_url)
    
def pets_ecard_display(test):
    """Steps to verify user can view the pets eCards page.   
        @param test: Instance of selenium object.
        
    """
    test.browser.find_element_by_xpath("//div[@id='test']/a[contains(text(), 'Pets')]").click()
    expected_page_url = "http://www.bluemountain.com/ecards/pets"
    wait_for_expected_url(test, expected_page_url)
    
def thankyou_ecard_display(test):
    """Steps to verify user can view the thankyou eCards page.   
        @param test: Instance of selenium object.
        
    """
    test.browser.find_element_by_xpath("//div[@id='test']/a[contains(text(), 'Thank You')]").click()
    expected_page_url = "http://www.bluemountain.com/ecards/thank-you"
    wait_for_expected_url(test, expected_page_url)

def holidays_ecard_display(test):
    """Steps to verify user can view the holidays eCards page.   
        @param test: Instance of selenium object.
        
    """
    test.browser.find_element_by_xpath("//div[@id='test']/a[contains(text(), 'View All Holidays')]").click()
    expected_page_url = "http://www.bluemountain.com/ecards/holidays"
    wait_for_expected_url(test, expected_page_url)
    
def valentines_day_ecard_display(test):
    """Steps to verify user can view the valentines day eCards page.   
        @param test: Instance of selenium object.
        
    """
    # To verify user can view the holidays eCards page.
    holidays_ecard_display(test)    
    # To verify user can view the valentines day eCards page.
    test.browser.find_element_by_xpath("//div[@id='main']/aside/div/div/ul/li[2]/div/a/div").click()
    expected_page_url = "http://www.bluemountain.com/ecards/valentines-day"
    wait_for_expected_url(test, expected_page_url)
    
def easter_ecard_display(test):
    """Steps to verify user can view the easter eCards page.   
        @param test: Instance of selenium object.
        
    """
    # To verify user can view the holidays eCards page.
    holidays_ecard_display(test)    
    # To verify user can view the easter eCards page.
    test.browser.find_element_by_xpath("//li[4]/div/a/div").click()
    expected_page_url = "http://www.bluemountain.com/ecards/easter"
    wait_for_expected_url(test, expected_page_url)
    
def halloween_ecard_display(test):
    """Steps to verify user can view the halloween eCards page.   
        @param test: Instance of selenium object.
        
    """
    # To verify user can view the holidays eCards page.
    holidays_ecard_display(test)
    
    # To verify user can view the halloween eCards page.
    test.browser.find_element_by_xpath("//li[9]/div/a").click()
    expected_page_url = "http://www.bluemountain.com/ecards/halloween"
    wait_for_expected_url(test, expected_page_url)
    
def thanksgiving_ecard_display(test):
    """Steps to verify user can view the thanksgiving eCards page.   
        @param test: Instance of selenium object.
        
    """
    # To verify user can view the holidays eCards page.
    holidays_ecard_display(test)    
    # To verify user can view the thanksgiving eCards page.
    test.browser.find_element_by_xpath("//li[10]/div/a/div").click()
    expected_page_url = "http://www.bluemountain.com/ecards/thanksgiving"
    wait_for_expected_url(test, expected_page_url)
    
def seasons_ecard_display(test):
    """Steps to verify user can view the seasons eCards page.   
        @param test: Instance of selenium object.
        
    """
    # To verify user can view the holidays eCards page.
    holidays_ecard_display(test)    
    # To verify user can view the seasons eCards page.
    test.browser.find_element_by_xpath("//li[12]/div/a/div").click()
    expected_page_url = "http://www.bluemountain.com/ecards/seasons-greetings"
    wait_for_expected_url(test, expected_page_url)
    
def christmas_ecard_display(test):
    """Steps to verify user can view the christmas eCards page.   
        @param test: Instance of selenium object.
        
    """
    # To verify user can view the holidays eCards page.
    holidays_ecard_display(test)    
    # To verify user can view the christmas eCards page.
    test.browser.find_element_by_xpath("//li[13]/div/a/div").click()
    expected_page_url = "http://www.bluemountain.com/ecards/christmas"
    wait_for_expected_url(test, expected_page_url)
    
def christmas_for_everyone_ecard_display(test):
    """Steps to verify user can view the christmas for everyone eCards page.   
        @param test: Instance of selenium object.
        
    """
    # To verify user can view the christmas eCards page.
    christmas_ecard_display(test)    
    # To verify user can view the christmas for everyone eCards page.
    test.browser.find_element_by_xpath("//div[@id='test']/a[contains(text(), 'For Everyone')]").click()
    expected_page_url = "http://www.bluemountain.com/ecards/christmas/everyone"
    wait_for_expected_url(test, expected_page_url)
    
def christmas_religious_ecard_display(test):
    """Steps to verify user can view the christmas religious eCards page.   
        @param test: Instance of selenium object.
        
    """
    # To verify user can view the christmas eCards page.
    christmas_ecard_display(test)    
    # To verify user can view the christmas religious eCards page.
    test.browser.find_element_by_xpath("//div[@id='test']/a[contains(text(), 'Religious')]").click()
    expected_page_url = "http://www.bluemountain.com/ecards/christmas/spiritual"
    wait_for_expected_url(test, expected_page_url)