from realm import TestCase
from modules.login import forgot_password
from modules.loadpage import load_page


class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Test scenario: Verify the Addcontact functionality of BMA.  
            @param self: Instance of test script class.
                  
        """ 
        # MCP: Registered user.
        account_type = 'mcp'    
            
        # Load home page.        
        load_page(self)
        # Login a registered user based on account!!
        forgot_password(self)