from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.custompd import add_message, custompd

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        
        """ The actual test scenario: Search talking eCard but not send .  
            @param self: Instance of test script class.
             
        """
        account_type = "mcp"
        ecard_type = "talking"
        operation = "send"
        
        # Load home page.                       
        load_page(self)
        #login 
        login(self, account_type)
        # Select eCard on basis of account type!
        card_selection(self, account_type, ecard_type)
        # Send eCard!!
        custompd(self, operation, account_type)