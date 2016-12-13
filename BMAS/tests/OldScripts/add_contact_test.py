from realm import TestCase
from modules.login import login
from modules.contacts import contacts
from modules.loadpage import load_page
from modules.addressbook import address_book


class SeleniumTestScript(TestCase):
	
	def test_my_test_case(self):
		""" Test scenario: Verify the Addcontact functionality of BMA.  
			@param self: Instance of test script class.
				  
		""" 
		# MCP: Registered user.
		account_type = 'mcp'	
			
		# Load home page.		
		load_page(self)
		# Login a registered user based on account!!
		login(self, account_type)
		# Goto address book.
		address_book(self)
		# Adding new contact.
		contacts(self)