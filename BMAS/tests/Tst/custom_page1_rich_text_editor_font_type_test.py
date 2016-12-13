from realm import TestCase
from modules.loadpage import load_page
from modules.login import login
from modules.cardselection import card_selection
from modules.custompd import message_font, send_ecard

class SeleniumTestScript(TestCase):
	
	def test_my_test_case(self):
		""" The actual test scenario: Test the eCard font type
		    change functionality on RTE box, for paid user. 		    
			@param self: Instance of test script class.
				  
		"""
		account_type  = 'mcp'
		selected_font = "Courier"

		# Load home page. 
		load_page(self);
		# Login a registered user based on account!
		login(self, account_type)
		# Select eCard!
		card_selection(self, account_type)
		# Step to verify font type change.
		message_font(self, selected_font)
		# Step to verify card send!
		send_ecard(self)
