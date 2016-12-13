from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.custompd import pickup
from modules.replycard import reply_card

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Sending eCard & check receive a copy of that.
            @param self: Instance of test script class.
             
        """
        account_type = 'mcp'  
        notification = 'send_copy'
        
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # select eCard
        card_selection(self, account_type)
        # Pickup send eCard.
        pickup(self, notification)
        # reply card test.
        reply_card(self)
        