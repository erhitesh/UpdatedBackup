from realm import TestCase
from modules.loadpage import load_page
from modules.login import login
from modules.cardselection import card_selection
from modules.custompd import verify_suggested_message, \
     add_suggested_message, send_ecard

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """Script to check the add suggested message on RTE.            
            @param self: Instance of test script class.
                  
        """
        account_type = 'mcp'

        # Load home page. 
        load_page(self);
        # Login a registered user based on account!
        login(self, account_type)
        # Select eCard!
        card_selection(self, account_type)
        # Select message.
        selected_message = add_suggested_message(self)
        # Step to verify suggested message.
        verify_suggested_message(self, selected_message)
        # Step to verify card send!
        send_ecard(self)
       