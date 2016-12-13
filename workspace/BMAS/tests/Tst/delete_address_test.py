from realm import TestCase
from modules.login import login
from modules.loadpage import load_page
from modules.addressbook import address_book
from modules.deleteaddress import delete_address

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ The actual test scenario: Test the contact delete service.  
            @param self: Instance of test script class.
            @type self: object
                  
        """ 
        account_type = "mcp"         
        # Load home page.    
        load_page(self)    
        # Login a registered user based on account!
        login(self, account_type, pickup=True)
        # Goto address book.
        address_book(self)
        # Deleting one existing contact.
        delete_address(self)