class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        else:
            temp = x
            y = 0
            while temp:
                y = y*10 + temp%10
                temp = temp / 10
        return x == y
