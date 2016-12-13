from realm import TestCase
from modules.loadpage import load_page
from modules.reminders import reminder_select


class SeleniumTestScript(TestCase):    
    def test_my_test_case(self):
        """ user selects to download a wallpaper calendar from the Free Downloads page.
            @param self: Instance of test script class.
             
        """
        wallpaper = 'Reminder'
		
        # Load home page.                       
        load_page(self)
        # Wallpaper preview.
        reminder_select(self)
       