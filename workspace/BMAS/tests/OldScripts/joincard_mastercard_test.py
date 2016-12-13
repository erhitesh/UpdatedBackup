from realm import TestCase
from modules.loadpage import load_page
from modules.joinlocation import join_location
from modules.ccpayment import cc_payment
from modules.confirmpd import confirm_pd
from modules.whopd import who_pd
from modules.orderpd import order_pd

class SeleniumTestScript(TestCase):
	
	def test_my_test_case(self):
		""" The actual test scenario: Test the customer join process service,
			with master card as card type for monthly subscription.  
			@param self: Instance of test script class.
				  
		"""
		location = "send"
		subscription = "month"
		payment  = "mastercard"

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
		confirm_pd(self)

