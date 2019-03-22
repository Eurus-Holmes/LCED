class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        while n%4 == 0:
            n /= 4
        if n%8 == 7:
            return 4
        a = 0
        while a*a <= n:
            b = int(math.sqrt(n - a*a))
            if a*a + b*b == n:
                return (not not a) + (not not b)  
            a = a + 1
        return 3
        
