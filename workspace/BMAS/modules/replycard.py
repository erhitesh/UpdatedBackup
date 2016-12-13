from selenium.webdriver.common.by import By
from realm.helpers import wait_element
from modules.custompd import verify_sends
from realm.data import send_to

def reply_card(test):
    """ steps for pickup_card & reply to the sender.
        @param test: Instance of test-case. 
    """
    # wait for few moments.
    wait_element(test, By.CSS_SELECTOR, "div#reply-text>p>a")
    # select a free reply card.
    ecards = test.browser.find_elements_by_css_selector("li.product>div>a")
    ecards[0].click()    
    wait_element(test, By.XPATH, "//*[@id='main']/div/h1/span")
    # Enter your message.
    msg_text = test.browser.find_element_by_id("message")
    msg_text.clear()
    msg_text.send_keys("Hello, Tester!!")
    # click on Email this postcard button.
    test.browser.find_element_by_id("email-postcard").click()
    # verify the test.
    verify_sends(test)