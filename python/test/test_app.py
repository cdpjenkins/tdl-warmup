import unittest

from app import App


class TestApp(unittest.TestCase):
    def test_sum(self):
        self.assertEqual(App.sum(1, 2), 3)
