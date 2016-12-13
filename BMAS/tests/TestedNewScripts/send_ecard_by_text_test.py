from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.custommobilepage import custom_mobilepage

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ The actual test scenario: Test the non photo eCard 
        send service with message.  
            @param self: Instance of test script class.
             
        """
        # This is paid user.
        account_type = 'mcp'  
        
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # Select eCard on basis of account type!
        card_selection(self, account_type)
        #send ecard by text
        custom_mobilepage(self)
        