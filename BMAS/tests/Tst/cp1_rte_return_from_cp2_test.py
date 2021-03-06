from realm import TestCase
from modules.loadpage import load_page
from modules.login import login
from modules.cardselection import card_selection
from modules.custompd import verify_font_size, send_ecard,\
     edit_message, apply_all_rte_tools

class SeleniumTestScript(TestCase):
	
	def test_my_test_case(self):
		""" The actual test scenario: Apply all customization functions on 
		custom page on eCard.      
			@param self: Instance of test script class.
				  
		"""		
		account_type = 'mcp'
		
		# Load home page. 
		load_page(self);
		# Login a registered user based on account!
		login(self, account_type)
		# Select eCard!
		card_selection(self, account_type)
		# Here we apply all available customization functions.
		apply_all_rte_tools(self)		
		# Edit RTE message and verify.
		edit_message(self);
		# Step to verify card send!
		send_ecard(self)
