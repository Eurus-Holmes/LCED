class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False

        alpha = [0] * 26
        beta = [0] * 26
        for c in s:
            alpha[ord(c) - 97] += 1
        for c in t:
            beta[ord(c) - 97] += 1
        return alpha == beta
