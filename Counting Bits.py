class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        dp = [0]
        i = 0
        while True:
            for j in xrange(1<<i, 1<<(i+1)):
                if j > num:
                    return dp
                dp.append(1 + dp[j - (1<<i)])
            i += 1
        return dp

        
