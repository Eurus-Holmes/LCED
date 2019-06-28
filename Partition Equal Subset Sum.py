class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        sums = sum(nums)
        if sums & 1: return False
        nset = set([0])
        for n in nums:
            for m in nset.copy():
                nset.add(m + n)
        return sums / 2 in nset
