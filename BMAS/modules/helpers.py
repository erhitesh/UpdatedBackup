import random
import time
from datetime import datetime, timedelta
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import ElementNotVisibleException

def new_email():
    """Randomly generate user email"""
    email = 'AGAuto-{0}@mii.imgag.com'.format(current_time("%m%d%y%I%M%S"))
    
    return email


def ucs_email_address():
    """Function returns a random generated email id for ucs"""
    ucs_email = 'qa_symbio_' + current_time("%m.%d.%Y_%H.%M.%S") + \
        '_' + random_lower(2) + '@mail4.americangreetings.com'
        
    return ucs_email

def current_time(date_format):
    """Format the date as per format string provided by user
       @param date_format: required date format string.
       @type date_format: String
       
    """
    formatted_current_time = datetime.now().strftime(date_format)
    
    return formatted_current_time

def random_name(length):
    """Function return a random name
       @param length:  random name string length.
       @type length: Integer 

    """
    name = ''
    characters_set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    for i in range(0, length):
        random_index = random.randint(0, len(characters_set) - 1)
        name = name + characters_set[random_index]

    return name


def random_string(length):
    """ Function return a random string.
        @param length: random string length.
        @type length: Integer

    """
    string = ""
    chars = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    for i in range(0, length):
        string = string + chars[random.randint(0, len(chars) - 1)]

    return string


def random_lower(length):
    """ Function return a random string in lower case.
        @param length: random lower case string length.
        @type length: Integer

    """
    chars = "abcdefghijklmnopqrstuvwxyz"
    random_string = ""
    for p in range(0, length):
        random_string = random_string + chars[random.randint(0, len(chars) - 1)]

    return random_string


def get_between(content, start, end):
    """Split contents by start and end delimiter, also return inner html.
       @param content: page source code in string.
       @type content: String
       @param start: start delimiter.
       @type content: String
       @param end: end delimiter
       @type content: String

    """
    # Split content based on string delimiter
    splited_contents = content.split(start)
    if splited_contents[1]:
        # split content based on end delimiter
        content_between = splited_contents[1].split(end)
        return content_between[0]

    return ''


def random_month(choice):
    """ Function returns month value on basis of choice full name, short or numbered.
        @param choice: required date form full name or short name
        @type choice: String

    """
    number = random.randint(0, 11)
    # Month in full text!
    months_fullname = ['January', 'February', 'March', 'April', 'May',
                       'June', 'July', 'August', 'September', 'October',
                       'November', 'December']
    # Month in short text form!
    months_shortname = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul',
                        'Aug', 'Sep', 'Oct', 'Nov', 'Dec']

    if choice == 'Num' or choice == 'num':
        formatted_month = "%02d" % (number + 1)
        return formatted_month
    elif choice == 'Full' or choice == 'full':
        return months_fullname[number]
    elif choice == 'Short' or choice == 'short':
        return months_shortname[number]


def random_bday(digits):
    """ Function returns random birth day date.
        @param digits: size of day format one or two digits example. 01 or 1.
        @type digits: Integer

    """
    number = random.randint(1, 28)
    if digits == 1:
        formatted_day = str(number)
    elif digits == 2:
        formatted_day = "%02d" % number

    return formatted_day


def random_byear():
    """ Function returns random birth day year """
    birthday_year = str(random.randint(1950, 1991))
    
    return birthday_year


def resend_date():
    """ Function returns re-send date as per current month. """
    today = datetime.today()
    first = datetime(day=1, month=today.month, year=today.year)
    lastMonth = first - timedelta(days=1)
    resend_day = lastMonth.strftime("%B %Y")

    return resend_day


def resend_year():
    """ Function returns re-send year next to current year. """
    resend_year = int(current_time("%Y")) + 1

    return resend_year


def wait_text(test, text):
    """ Function is used to wait for text to render on page and     
    if text not rendered in 60 seconds, test fail with timeout message.
        @param test: Instance of SeleniumTestScript class. 
        @type test: Class instance
        @param text: text on page to verify.  
        @type text: String
         
    """
    for i in range(60):
        try:
            if test.browser.page_source().find(text) > 0: 
                break
        except: 
            pass
        time.sleep(1)
    else: 
        test.fail("time out")


def browser_exception(test):
    """ Get the browser name from navigator agent.
        @param self: Instance of SeleniumTestScript class.
        @type test: Class instance
       
    """
    user_agent = test.browser.execute_script("navigator.userAgent")
    if user_agent.find("Firefox") > 0:
        browser_name = "Firefox"
    elif user_agent.find("MSIE") > 0: 
        browser_name = "MSIE"
    elif user_agent.find("Safari") > 0:
        browser_name = "Safari"
    else:
        browser_name = "UnKnown Browser."
      
    return browser_name

def wait_text(test, text):
   """ Function is used to wait for text to render on page and     
   if text not rendered in 60 seconds, test fail with timeout message.
       @param test: Instance of SeleniumTestScript class. 
       @param text: text on page to verify.  
       @type text: String  
        
   """
   timeout = 60
   
   for i in range(timeout):
       try:
           if test.browser.page_source.find(text) > 0: break
       except: pass
       time.sleep(1)
   else: 
       test.fail("time out")
