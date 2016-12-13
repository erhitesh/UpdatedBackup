from realm import TestCase
from modules.cardselection import card_selection
from modules.loadpage import load_page
from modules.login import login
from modules.custompd import verify_font_style, verify_font_color,\
     send_ecard

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Apply all customization option in custom page.  
            @param self: Instance of test script class.
             
        """
        account_type = 'mcp' 
        
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # Select eCard on basis of account type!
        card_selection(self, account_type)
        # Test font type functionalityd.
        verify_font_style(self)
        # Test font color functionalityd of custom page!
        verify_font_color(self)
        # Send eCard!
        send_ecard(self)