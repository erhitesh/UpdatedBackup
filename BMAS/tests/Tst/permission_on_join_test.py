from realm import TestCase
from modules.loadpage import load_page
from modules.joinlocation import join_location
from modules.whopd import who_pd
from modules.orderpd import order_pd
from modules.ccpayment import cc_payment
from modules.confirmpd import confirm_pd
from modules.myaccount import myaccount_test


class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ User can set permissions to enable/disable Automatic Sign-In and Email Preferences when they join BMA.
            @param self: Instance of test script class.
             
        """
        location = 'header'
        subscription = 'year' 
        payment = 'discover'
        permission = True
        # View type 
        view_type1 = 'view_settings'    
        # Load home page.  
        load_page(self)
        # Add a new customer based on location.
        join_location(self, location)
        # Register a new user.
        who_pd(self)
        # Add user information.
        order_pd(self, subscription)
        # Inserting credit card information.
        cc_payment(self, payment)
        # Validating membership confirmation!
        confirm_pd(self, permission)
        # My cards.
        # myaccount_test(self, view_type=view_type1)
#