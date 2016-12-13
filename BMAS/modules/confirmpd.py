import time
from selenium.webdriver.common.by import By
from realm.helpers import wait_text, wait_element
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import ElementNotVisibleException
from realm import data

def confirm_pd(test, permission=False):
    """ Steps to validate membership is confirm or not.
        @param test: Instance of test-case.
        @param permission: For permission information.
        
    """
    # Confirmation message is not showing due to firewall rule
    pass