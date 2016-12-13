from realm import TestCase
from modules.login import login
from modules.loadpage import load_page


class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Test scenario: Verify the login functionality of BMA.  
            @param self: Instance of test script class.
                  
        """ 
        # Existing user.
        account_type = 'mcp'    
            
        # Load home page.        
        load_page(self)
        # Login with a existing user!
        login(self, account_type)