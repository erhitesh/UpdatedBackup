from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.custompd import send_ecard

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Sending eCard to any future date.
            @param self: Instance of test script class.
             
        """
        option = 'future'
        account_type = 'mcp'
          
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # select eCard
        card_selection(self, account_type)
        # send eCard
        send_ecard(self, option)
       