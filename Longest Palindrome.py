class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        ans = odd = 0
        cnt = collections.Counter(s)
        for c in cnt:
            ans += cnt[c]
            if cnt[c]%2 == 1:
                ans -= 1
                odd += 1
        return ans + (odd>0)
