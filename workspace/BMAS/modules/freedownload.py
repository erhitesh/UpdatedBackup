from realm.helpers import wait_text

def free_download(test):
    
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
    test.browser.switch_to.window(handle[1])
    url_data = test.browser.current_url
    browser_url = "http://www.bluemountain.com/wallpapers/card?prodnum=3284950&file_size=1600x1200&navigation=385661&title=Purrty%20in%20Pink"
    # Verifing url
    test.assertEqual(browser_url, url_data)
    img_src = test.browser.find_element_by_xpath("//html/body/p/img")
    source = img_src.get_attribute("src")
    print source