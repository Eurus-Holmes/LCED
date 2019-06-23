class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        size = len(A)
        if size < 3: return 0
        ans = cnt = 0
        delta = A[1] - A[0]
        for x in range(2, size):
            if A[x] - A[x - 1] == delta:
                cnt += 1
                ans += cnt
            else:
                delta = A[x] - A[x - 1]
                cnt = 0
        return ans
