from realm import TestCase
from modules.loadpage import load_page
from modules.login import login
from modules.cardselection import card_selection
from modules.custompd import verify_font_size, send_ecard

class SeleniumTestScript(TestCase):
	
	def test_my_test_case(self):
		""" The actual test scenario: Test the eCard font minimum
		size change functionality on RTE box, for paid user.  		    
			@param self: Instance of test script class.
				  
		"""		
		command = 'MIN'
		account_type = 'mcp'
		
		# Load home page. 
		load_page(self);
		# Login a registered user based on account!
		login(self, account_type)
		# Select eCard!
		card_selection(self, account_type)
		# Step to verify font min size change.
		verify_font_size(self, command)
		# Step to verify card send!
		send_ecard(self)
