import time
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

from realm.helpers import wait_element
from realm.helpers import wait_text
from realm.data import customer_accounts, password, pickup_account
from selenium.webdriver.common.action_chains import ActionChains


def join_now(test):
    """ Select the join now link.
        @param test: Instance of test-case. 

    """
    wait_element(test, By.ID, "agi-join")
    test.browser.find_element_by_id("agi-join").click()

def sign_in(test):
    """ Select the sign in link.
    @param test: Instance of test-case.
    
    """
    wait_element(test, By.ID, "agi-signin")
    test.browser.find_element_by_id("agi-signin").click()

def verify_signin(test):
    """ Verification for user signin successful or not.
        @param test: Instance of test-case. 

    """
    wait_element(test, By.ID, "agi-signout")

    
def sign_out(test):
    """ Sign Out from the site.
        @param test: Instance of test-case. 

    """
    wait_element(test, By.ID, "agi-signout")
    test.browser.find_element_by_id("agi-signout").click()   
    
def get_username(test, account, pickup):
    if pickup:
         email = pickup_account['email']
    else:
        if account == 'mcp':        
             email = customer_accounts['mcp']
        elif account == 'rfu':      
             email = customer_accounts['rfu']
        elif account == 'resend':        
             email = customer_accounts['resend']

    return email 

def get_password(test, pickup):
    """If user forgot password.
       @param test: Selenium browser instance.
       
    """
    user_password = pickup_account['password'] if pickup else  password
    return user_password

def forgot_password(test):
    """If user forgot password.
       @param test: Selenium browser instance.
       
    """
    join_now(test)
    test.browser.find_element_by_id('forgot-password-link').click()
    email_address = test.browser.find_element_by_id("email")
    email_address.send_keys(customer_accounts['rfu'])
    test.browser.find_element_by_id('submit-pw-forgot').click()    
    wait_text(test, "Your Password is on the way!")    
    
def login_via_join(test, account, pickup):
    """ Steps to logged in already registered user via join now page.
        @param test: Instance of test-case. 
        @param account: Type of user account.  

    """
    join_now(test)
    test.browser.find_element_by_id("existing-email-input").send_keys(get_username(test, account, pickup)) 
    test.browser.find_element_by_id("existing-password-input").send_keys(get_password(test, pickup))
    test.browser.find_element_by_id("sign-in-button").click()
    verify_signin(test)

def login_via_signin(test, account, pickup):
    """ Steps to logged in already registered user.
        @param test: Instance of test-case. 
        @param account: Type of user account.  

    """	
    sign_in(test)
    time.sleep(2)
    test.browser.switch_to.frame("lightboxloader")
    wait_element(test, By.ID, "email")
    test.browser.find_element_by_id("email").send_keys(get_username(test, account, pickup)) 
    test.browser.find_element_by_id("password").send_keys(get_password(test, pickup))
    test.browser.find_element_by_id('submit-login').click()
    test.browser.switch_to.default_content()
    verify_signin(test)

def login(test, account, login_via='signin', pickup=False):	
    """ Sign in user based on join or sign in page.
        @param test: Selenium browser instance. 

    """
    if login_via == 'join':        
        login_via_join(test, account, pickup)    # Login using join now page.
    elif login_via == 'signin':
        login_via_signin(test, account, pickup)	 # Login using sign in page.
    
def mail_login(test):    
    """ Steps for login into email to pickup eCard.
        @param test: Instance of test-case.
        
    """ 
    test.browser.find_element_by_tag_name("body").send_keys(Keys.CONTROL + 't')
    test.browser.get("http://www.yahoomail.com")
    test.browser.refresh()
    wait_element(test, By.ID, "mbr-login-box")
    test.browser.find_element_by_id("login-username").send_keys(pickup_account['email'])
    test.browser.find_element_by_id("login-passwd").send_keys(pickup_account['password'])
    test.browser.execute_script("var x = window.document.createElement('button'); \
                       x.type = 'hidden';x.value = '1'; x.name = \"signin.x\"; \
                       var y = window.document.getElementById('mbr-login-form'); \
                       y.appendChild(x); window.document.getElementById('mbr-login-form').submit();")
    time.sleep(5)
    test.browser.save_screenshot("error.jpg")
    wait_element(test, By.ID, "msg-list")  