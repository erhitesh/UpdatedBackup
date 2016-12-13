from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.custompd import pickup

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Sending eCard & check notification mail whether ecard pickup or not.
            @param self: Instance of test script class.
             
        """
        
        notification = 'notify_pickup'
        account_type = 'mcp'  
        
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # select eCard
        card_selection(self, account_type)
        # Verify pickup eCard.
        pickup(self, notification)
        
        