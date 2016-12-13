
def delete_address(test):
    """ Steps to delete a contact from user address book
        of site.             
        @param test: Instance of test-case.
        
    """
    expected_title = "Free Ecards and Printable Greeting Cards Online at Blue Mountain"
    
    # Click on edit link on contact list.
    edit_link_list = test.browser.find_elements_by_link_text("edit")
    edit_link_list[0].click()
    # Click on delete contact button.
    test.browser.find_element_by_link_text("Delete This Contact").click()
    # Handle alert on delete contact!
    alert = test.browser.switch_to_alert()
    alert.accept
    print "ok"
    test.assertEqual(expected_title, test.browser.title)
