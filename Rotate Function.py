class Solution(object):
    def maxRotateFunction(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        sum = 0
        N = len(A)
        f = 0
        for i, a in enumerate(A):
            sum += a
            f += i*a
        res = f
        for i in range(N-1, 0, -1):
            f = f + sum - N*A[i]
            res = max(res, f)
        return res
        
