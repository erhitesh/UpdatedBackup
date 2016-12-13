from realm import make_url

def load_page(test):
	""" Function to navigate to url.
		@param test: Instance of realm.TestCase class
		@type test: Object 
		
	"""
	# make_url: Makes a full URL (including domain) with the given path.
	test.browser.get(make_url('/'))  
