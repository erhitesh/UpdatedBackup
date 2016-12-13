from realm import TestCase
from modules.loadpage import load_page
from modules.login import login 
from modules.wallpaper_download import free_wallpaper_download


class SeleniumTestScript(TestCase):
    
    def test_my_test_case(self):
        """ Functionality to check user can download free wallpapers.
            @param self: Instance of test script class.
             
        """
        # This is paid user.
        account_type = 'mcp'  
        # Load home page.                       
        load_page(self)
        # Login a registered user based on account!
        login(self, account_type)
        # wallpaper download.
        free_wallpaper_download(self)