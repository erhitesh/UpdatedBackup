import unittest2 as unittest

if __name__ == "__main__":
    suite = unittest.TestLoader().discover('./tests/Tst', pattern = "*test.py")
    unittest.TextTestRunner(verbosity=2).run(suite)