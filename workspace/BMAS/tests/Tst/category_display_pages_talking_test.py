from realm import TestCase
from modules.category_display import talking_ecard_display
from modules.loadpage import load_page

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Test scenario: Verify the functionality of user can view the talking eCards page.  
            @param self: Instance of test script class.
                  
        """ 
        # Load home page.        
        load_page(self)
        # Verify ecard page.        
        talking_ecard_display(self)