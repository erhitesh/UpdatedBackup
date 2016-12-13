from selenium import webdriver

# The HTTP port to use.
http_port = 80

# The HTTPS port to use.
https_port = 443

# Server to use.
#server = 'stage.web1.bluemountain.com'
server = 'bluemountain.com'
# The standalone Selenium server to run the tests on.
#selenium_server = 'http://assurance.ops.ag.com:4444/wd/hub'
selenium_server = 'http://127.0.0.1:4444/wd/hub'


# Default timeout (in seconds) to wait for items in the DOM to load.
default_timeout = 30

# This property stores various useful PhantomJS capabilities settings of the web page:
capabilities_settings = {'acceptSslCerts':True, 'handlesAlerts':True}
