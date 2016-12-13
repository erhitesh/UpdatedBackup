from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.custompd import add_photo, add_message,\
     custompd

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ The actual test scenario: Test the non photo eCard 
        send service with message.  
            @param self: Instance of test script class.
             
        """
        # This is paid user.
        account_type = "mcp"
        operation = "send"  
        
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # Select eCard on basis of account type!
        card_selection(self, account_type)
        # Add a photo from system drive.
        add_photo(self)
        # Enter some message on eCard!
        add_message(self)
        # Send eCard!
         # Step to verify card preview and send!
        custompd(self, operation, account_type)