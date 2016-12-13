from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.customfacebookpd import post_ecard_to_facebook

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ The actual test scenario: Test the non photo eCard 
        send service with message.  
            @param self: Instance of test script class.
             
        """
        facebook_option = 'share'
        account_type = 'mcp' 
         
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # Select eCard on basis of account type!
        card_selection(self, account_type) 
        # for facebook login and post
        post_ecard_to_facebook(self, facebook_option)