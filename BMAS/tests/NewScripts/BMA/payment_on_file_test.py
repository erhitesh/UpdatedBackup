from realm import TestCase
from modules.loadpage import load_page
from modules.login import login



class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ User using already saved credit card details in payment page for payment.
            @param self: Instance of test script class.
             
        """
        # This is paid user.
        account_type = 'mcp'
        login_via = 'signin'
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self,account_type, login_via)
        
       
