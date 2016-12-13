from realm import TestCase
from modules.loadpage import load_page
from modules.login import login
from modules.myaccount import myaccount_test


class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ User can see your received gift cards.
            @param self: Instance of test script class.
             
        """
        # This is paid user.
        account_type = 'mcp'
        # view type 
        view_type = 'gifts_receive'
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account! 
        login(self, account_type)
        # My account info
        myaccount_test(self, view_type)
       
       