from realm import TestCase
from modules.loadpage import load_page
from modules.joinlocation import join_location
from modules.confirmpd import confirm_pd
from modules.whopd import who_pd
from modules.orderpd import order_pd
from modules.ecppayment import ecp_payment

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ The actual test scenario: Test the customer join process service,
            with cheque as payment method for yearly subscription.  
            @param self: Instance of test script class.
                  
        """
        location = 'send'
        subscription = 'year' 
                
        # Load home page.
        load_page(self)
        # Add a new customer based on location.
        join_location(self, location)
        # Register a new user.
        who_pd(self)
        # Add user information.
        order_pd(self, subscription)
        # Inserting cheque information.
        ecp_payment(self)
        # Validating membership confirmation!
        confirm_pd(self)