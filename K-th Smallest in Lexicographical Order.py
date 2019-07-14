class Solution(object):
    def findKthNumber(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        ans = 1
        k -= 1
        while k > 0:
            gap = self.findGap(n, ans, ans + 1)
            if gap <= k:
                ans += 1
                k -= gap
            else:
                ans *= 10
                k -= 1
        return ans

    def findGap(self, n, p, q):
        gap = 0
        while p <= n:
            gap += max(0, min(n + 1, q) - p)
            p *= 10
            q *= 10
        return gap
        
