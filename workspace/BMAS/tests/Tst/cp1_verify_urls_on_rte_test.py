from realm import TestCase
from modules.login import login
from modules.loadpage import load_page
from modules.cardselection import card_selection
from modules.custompd import urls_as_message_text, send_ecard

class SeleniumTestScript(TestCase):
	
	def test_my_test_case(self):
		""" The actual test scenario: Test to verify url string in message
		box of eCard on RTE box, for paid user.  		    
			@param self: Instance of test script class.
				  
		"""
		account_type = "mcp"
		url = "www.americangreetings.com"

		# Load home page. 
		load_page(self);
		# Login a registered user based on account!
		login(self, account_type)
		# Select eCard!
		card_selection(self, account_type)
		# Step to verify url string in message box
		urls_as_message_text(self, url)
		# Step to verify card send!
		send_ecard(self)