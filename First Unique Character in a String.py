class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = collections.Counter(s)
        ans = -1
        for x, c in enumerate(s):
            if d[c] == 1:
                ans = x
                break
        return ans
        
