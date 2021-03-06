from realm import TestCase
from modules.login import login
from modules.loadpage import load_page
from modules.cardselection import card_selection
from modules.custompd import custompd

class SeleniumTestScript(TestCase):
	
	def test_my_test_case(self):
		"""The actual test scenario: Test the eCard send service,
		for registered free user.  
			@param self: Instance of test script class.
				  
		"""  
		account_type = 'rfu'
		operation = 'send'
				
		# Load home page. 
		load_page(self);
		# Login a registered user based on account!
		login(self, account_type)
		# Select eCard!
		card_selection(self, account_type)
		# Step to verify card send!
		custompd(self, operation, account_type)