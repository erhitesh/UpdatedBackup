from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.custompd import add_photo, send_ecard

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ The actual test scenario: Test the non photo eCard 
        send service without message.  
            @param self: Instance of test script class.
             
        """
        account_type = 'mcp'  # This is paid user.
        
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # Select eCard on basis of account type!
        card_selection(self, account_type)
        # Add a photo from system drive.
        add_photo(self)
        # Send eCard!
        send_ecard(self)
