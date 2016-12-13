from realm import TestCase
from modules.loadpage import load_page
from modules.cnp_cardselection import cnp_card_selection
from modules.cnpdisplay import cnp_display

class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ The actual test scenario: Test the create & print eCard 
            display service.  
            @param self: Instance of test script class.
                  
        """    
        # Load home page.               
        load_page(self)
        # Select create & print eCard!
        cnp_card_selection(self)
        # Step to verify card title!
        cnp_display(self)