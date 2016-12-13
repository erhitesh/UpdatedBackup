from realm.helpers import wait_text, wait_for_expected_url

def free_wallpaper_download(test):
    
    """ Steps to download free wallpapers. 
        @param test: Instance of test-case.
        
    """

    # Click on free download button.
    test.browser.find_element_by_link_text("Free Downloads").click()
    # Click on any wallpaper .
    test.browser.find_element_by_xpath("//*[@id='small-thumb-3284950']").click()
    #test.browser.find_element_by_css_selector("img#small-thumb-3284950").click()
    # wait for some moments.
    wait_text(test, "Wallpapers")
    # Click on Download button.
    test.browser.find_element_by_xpath("//img[@alt='Download Now']").click()
    # For window handling.
    handle = test.browser.window_handles
    test.browser.switch_to_window(handle[1])
    browser_url = "http://www.bluemountain.com/wallpapers/card?prodnum=3284950&file_size=1024x768&navigation=385661&title=Purrty%20in%20Pink"
    wait_for_expected_url(test, browser_url)