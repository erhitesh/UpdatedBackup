from realm import TestCase
from modules.login import login
from modules.custompd import custompd
from modules.loadpage import load_page
from modules.cardselection import card_selection

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Steps to validate the preview option in site.
            @param self: Instance of test script class.
                  
        """   
        account_type = "mcp"
        operation = "preview"
             
        # Load home page.            
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # Select eCard!
        card_selection(self, account_type)
        # Step to verify card preview and send!
        custompd(self, operation, account_type)
        