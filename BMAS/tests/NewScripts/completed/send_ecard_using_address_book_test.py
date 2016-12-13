from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login 
from modules.custompd import address_book

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Sending eCard by selecting Recipients from address book.
            @param self: Instance of test script class.
             
        """
        # This is paid user.
        account_type = 'mcp'  
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # select eCard
        card_selection(self, account_type)
        # address book
        address_book(self)
        
       