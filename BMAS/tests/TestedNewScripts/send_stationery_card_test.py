from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.custompd import custompd


class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Sending Stationery eCard.
            @param self: Instance of test script class.
             
        """
        account_type = 'mcp'  
        ecard_type = 'stationery'
        operation = 'send'
        
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # Select eCard!
        card_selection(self, account_type, ecard_type)
        # Send stationery card.
        custompd(self, operation, account_type)