def re_send(test):
    """ re_send module used to automate the process of 
    re-send functionality.
        @param test: Instance of test-case. 
        
    """
    test.find_elements_by_link_text("My Account").click()
    test.find_elements_by_link_text("eCards & Gifts Sent").click()
    test.find_elements_by_link_text("Resend").click()
    test.find_element_by_id("resend_button").click()
