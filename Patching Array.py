class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        idx, total, ans = 0, 1, 0
        size = len(nums)
        while total <= n:
            if idx < size and nums[idx] <= total:
                total += nums[idx]
                idx += 1
            else:
                total <<= 1
                ans += 1
        return ans
        
