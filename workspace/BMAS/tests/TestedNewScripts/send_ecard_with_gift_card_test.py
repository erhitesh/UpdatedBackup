from realm import TestCase
from modules.loadpage import load_page
from modules.login import login
from modules.cardselection import card_selection
from modules.custompd import custompd

class SeleniumTestScript(TestCase):
    
    def test_bma_script(self):
        """ The actual test scenario: Test the eCard send service,
            for paid user with gift attached.  
            @param self: Instance of test script class.
                  
        """
        account_type = 'mcp'
        option = 'giftsend'

        # Load home page.
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # Select eCard!
        card_selection(self, account_type)
        # Step to verify card send and preview!
        custompd(self, option, account_type)