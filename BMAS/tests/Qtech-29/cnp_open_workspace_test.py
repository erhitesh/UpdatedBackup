from realm import TestCase
from modules.loadpage import load_page
from modules.login import login



class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ User can access the Create and Print workspace for any Printable Card.
            @param self: Instance of test script class.
             
        """
        # This is paid user.
        account_type = 'mcp'
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account! 
        login(self)

       
       