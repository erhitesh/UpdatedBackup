from realm.helpers import wait_text

def afu_confirm_pd(test):
    """ Steps to confirm eCard is send by afu account. 
        @param test: Instance of test-case.
        
    """  
    wait_text(test,"Your eCard has been sent!")
  
