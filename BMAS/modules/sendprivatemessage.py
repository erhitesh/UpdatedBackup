
from realm.data import facebook_user

import time

def send_privatemessage(test):
    
    test.browser.find_element_by_xpath("//*[@id='agi-facebook-send']").click()
    test.browser.find_element_by_link_text("Sign in to Facebook").click()
    print test.browser.window_handles
    #switch to window
    handle = test.browser.window_handles
    test.browser.switch_to.window(handle[1])
    # for email
    emailname = test.browser.find_element_by_id("email")
    emailname.clear()
    emailname.send_keys(facebook_user['email'])
    #test.assertEqual(facebook_user['email'], emailname.get_Attribute("value"))
    #for password
    test.browser.find_element_by_id("pass").clear()
    test.browser.find_element_by_id("pass").send_keys(facebook_user['password'])
    # for login
    test.browser.find_element_by_id("u_0_1").click()
    time.sleep(5)
    
    test.browser.switch_to.window(handle[0])
        
    test.browser.find_element_by_xpath("//div[@id='agi-fbsend-to-friends']/div/a").click()
    
    #switch to frame
    test.browser.switch_to_frame(test.browser.find_element_by_class_name("FB_UI_Dialog"))
    
    # for selected friend
    towhom = test.browser.find_element_by_id("u_0_0")
    towhom.clear()
    towhom.send_keys("Antony Barnabas")
    #test.assertEqual("Antony Barnabas", towhom.get_Attribute("value"))
    
    #for message
    test.browser.find_element_by_id("feedform_user_message").clear()
    test.browser.find_element_by_id("feedform_user_message").send_keys("Hi Hello Antony Barnabas")
    #for sending
    test.browser.find_element_by_id("u_0_6").click()
    
    #switch to default contents
    test.browser.switch_to.default_content()
    
    
        

    