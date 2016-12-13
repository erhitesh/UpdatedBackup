import unittest2 as unittest

from selenium.webdriver.phantomjs.service import Service
from selenium import webdriver
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
###from assurance.settings import PATHS
from . import config, helpers, data
import os

__all__ = ['config', 'browser', 'TestCase', 'helpers', 'make_url']


class TestCase(unittest.TestCase):

    @classmethod
    def setUp(cls):
        """Setup the Headless driver using PhantomJS to test scripts."""
        #cls.browser = webdriver.Remote(command_executor=config.selenium_server, desired_capabilities=DesiredCapabilities.FIREFOX)
        cls.browser = webdriver.PhantomJS(service_args=['--ignore-ssl-errors=true', '--web-security=false', '--ssl-protocol=any'])
        cls.browser.maximize_window()
        cls.browser.delete_all_cookies()
        
    @classmethod
    def tearDown(cls):
        cls.browser.quit()   

def make_url(path='', secure=False):
    ##Makes a full URL (including domain) with the given path.

	#:param path: The URL path (e.g. '/foo/bar')
    #:type path: string
    #:param secure: Whether to create a secure (HTTPS) url or not
    #:type secure: bool
    #:return: Returns the full URL
    #:rtype: string

    protocol = ('https' if secure else 'http')
    server = config.server.rstrip('/')
    path = path.lstrip('/')
    if not secure:
        port = '' if config.http_port == 80 else ':' + str(config.http_port)
    else:
        port = '' if config.https_port == 443 else ':' + str(config.https_port)

    return '{protocol}://www.{server}{port}/{path}'.format(**locals())