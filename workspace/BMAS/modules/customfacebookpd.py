import time
from selenium.webdriver.common.by import By

from realm.data import facebook_user
from realm.helpers import wait_element

__all__ = ["agi_facebook_send", "post_ecard_to_facebook", "post_to_friend_wall", \
           "post_on_own_wall", "post_on_wall", "switch_to_window", "switch_to_default_window", \
           "login_into_facebook", "post_private_message_on_facebook"]


def agi_facebook_send(test):
    """Selecting the facebook send button in custom page.
       @param test: Instance of testcase.
    
    """
    wait_element(test, By.ID, 'agi-facebook-send')
    test.browser.find_element_by_id('agi-facebook-send').click()

def post_ecard_to_facebook(test, option):
    """ Function automate the process of post eCard on friends 
    or own Facebook wall.
         @param test: Instance of testcase.
         @param option: post or share eCard option.
    
    """
    agi_facebook_send(test)
    # Post ecard on own or friend wall. 
    if option == 'post_on_friend_wall':
        post_on_friend_wall(test)
    elif option == 'post_on_own_wall':    
        post_on_own_wall(test)
    elif option == 'post_on_friend_msg':    
        post_private_message_on_facebook(test)
     
def post_on_friend_wall(test):
    """ Function to post a ecard on friends wall.
        @param test: Instance of testcase.
           
    """
    wait_element(test, By.LINK_TEXT, 'Sign in to Facebook')
    test.browser.find_element_by_link_text('Sign in to Facebook').click()
    time.sleep(1)
    handle = switch_to_window(test)
    login_into_facebook(test)
    switch_to_default_window(test, handle)
    post_on_wall(test)
    
def post_on_own_wall(test):
    """ Function to post a ecard on own wall.
        @param test: Instance of testcase.
           
    """
    # Switch to facebook login window.
    test.browser.find_element_by_link_text('Share this ecard').click()
    handle = switch_to_window(test)
    login_into_facebook(test)
    test.browser.find_element_by_id("u_0_2").click()
    # switch to original window
    switch_to_default_window(test, handle)

def post_on_wall(test):
    """ Select friend and post.
        @param test: Instance of testcase.
           
    """
    wait_element(test, By.XPATH, "//a[.='post']")
    friendlist_links = test.browser.find_elements_by_xpath("//a[.='post']")
    friendlist_links[0].click() 
    time.sleep(5)   
    # switch to post share window.
    handle = switch_to_window(test) 
    # Share post!!
    wait_element(test, By.ID, "u_0_0")
    test.browser.find_element_by_id("u_0_0").click()       
    # switch to original window
    switch_to_default_window(test, handle)
        
def switch_to_window(test):
    """Switch to new window"""
    # Switch to facebook login window.
    handle = test.browser.window_handles
    test.browser.switch_to.window(handle[1])
    
    return handle
    
def switch_to_default_window(test, handle):   
    """ Switch back to default window.
        @param test: Instance of testcase.
           
    """
    #switch to original window
    test.browser.switch_to.window(handle[0]) 
    
def login_into_facebook(test):
    """ Steps to login into facebook account.
        @param test: Instance of testcase.
    
    """
    # Enter username and password.
    wait_element(test, By.ID, "email")
    username_text = test.browser.find_element_by_id("email")
    username_text.send_keys(facebook_user['email'])
    password_text = test.browser.find_element_by_id("pass")
    password_text.send_keys(facebook_user['password'])
    # Submit the login form!!
    test.browser.find_element_by_id("u_0_1").click()    

def post_private_message_on_facebook(test):
    """ Steps to send a private message on friend facebook
    account. 
        @param test: Instance of testcase.
    
    """
    agi_facebook_send(test)
    post_on_friend_wall(test)          
    test.browser.find_element_by_xpath("//div[@id='agi-fbsend-to-friends']/div/a").click()    
    #switch to facebook dialog iframe!!
    test.browser.switch_to_frame(test.browser.find_element_by_class_name("FB_UI_Dialog"))    
    # for selected friend
    time.sleep(5)
    test.browser.find_element_by_id("u_0_0").send_keys("Antony Barnabas")
    test.browser.find_element_by_id("feedform_user_message").send_keys("Hi, Antony Barnabas...!!")
    # Send Message.
    test.browser.find_element_by_id("u_0_7").click()    
    #switch to default contents
    test.browser.switch_to.default_content()