from realm import TestCase
from modules.loadpage import load_page
from modules.login import login
from modules.cardselection import card_selection
from modules.custompd import verify_font_size, send_ecard,\
     verify_special_text_message

class SeleniumTestScript(TestCase):
	
	def test_my_test_case(self):
		""" The actual test scenario: Test the eCard with blank message.		      
			@param self: Instance of test script class.
				  
		"""		
		message_text = ''
		account_type = 'mcp'
		
		# Load home page. 
		load_page(self);
		# Login a registered user based on account!
		login(self, account_type)
		# Select eCard!
		card_selection(self, account_type)
		# Validate for blank message on RTE.
		verify_special_text_message(self, message_text);
		# Step to verify card send!
		send_ecard(self)