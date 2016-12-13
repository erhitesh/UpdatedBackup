from realm import TestCase
from modules.loadpage import load_page
from modules.login import login 
from modules.wallpaperpreview import wallpaper_preview


class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ User can download free wallpapers.
            @param self: Instance of test script class.
             
        """
        # This is paid user.
        account_type = 'mcp'  
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # wallpaper download.
        wallpaper_preview(self)
       