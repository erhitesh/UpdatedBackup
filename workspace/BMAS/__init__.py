import unittest2 as unittest

from selenium import webdriver
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
from realm import config
from realm import data
from realm import helpers

__all__ = ['config', 'browser', 'TestCase', 'helpers', 'make_url']


class TestCase(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        cls.browser = webdriver.Firefox()
        cls.browser.implicitly_wait(config.default_timeout)
        cls.browser.maximize_window()


    @classmethod
    def tearDownClass(cls):
        cls.browser.close()

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

    return '{protocol}://{server}{port}/{path}'.format(**locals())


  
