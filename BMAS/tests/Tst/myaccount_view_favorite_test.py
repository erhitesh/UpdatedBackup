from realm import TestCase
from modules.loadpage import load_page
from modules.login import login
from modules.myaccount import myaccount_test


class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ user can see your saved favourites ecards.
            @param self: Instance of test script class.
             
        """
        
        # This is paid user.
        account_type = 'mcp'
        # view type 
        view_type = 'favorites'
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # My cards.
        myaccount_test(self, view_type)
       