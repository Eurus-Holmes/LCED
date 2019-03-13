class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        count = collections.Counter(nums)
        res = []
        for nums, c in count.items():
            if c == 1:
                res.append(nums)
        return res
