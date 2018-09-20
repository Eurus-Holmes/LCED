class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums:
            return False
        length = len(nums)
        index = 0
        longest = nums[0]
        while index <= longest:
            if longest >= length - 1:
                return True
            longest = max(longest, index + nums[index])
            index += 1
        return False
        
