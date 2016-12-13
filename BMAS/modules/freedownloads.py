import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

from realm.data import send_to
from realm.helpers import wait_text, wait_element
from realm.helpers import new_email, random_name,\
     random_month, random_bday, random_byear
from .orderpd import create_free_account     


def wallpaper_download(test):
    """ Steps to preview free wallpaper & download wallpaper using 
    registr free user(rfu). 
        @param test: Instance of test-case.
        @param wallpaper: Download or preview.
        
    """ 
    wallpaper_selection(test)
    # For window handling.
    handle = test.browser.window_handles
    test.browser.switch_to.window(handle[1])
    cur_url = test.browser.current_url
    test.assertTrue(cur_url.find("wallpapers/card") >=0)

def wallpaper_preview(test):
    """ Steps to preview free wallpaper.
        @param test: Instance of test-case.
        @param wallpaper: Download or preview.
        
    """
    wallpaper_selection(test)
    create_free_account(test)
             
def wallpaper_selection(test):
    test.browser.find_element_by_link_text("Free Downloads").click()
    test.browser.find_elements_by_class_name("small-thumb")[0].click()
    wait_element(test, By.XPATH, "//img[@alt='Download Now']")
    test.browser.find_element_by_xpath("//img[@alt='Download Now']").click()
    time.sleep(2)