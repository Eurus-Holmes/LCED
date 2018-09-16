class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 1
        i = 0
        length = len(nums)
        while i < length:
            current = nums[i]
            if current <= 0 or current > length or nums[current - 1] == current:
                i += 1
            else:
                nums[current - 1], nums[i] = nums[i], nums[current - 1]

        for i in range(length):
            if nums[i] != i + 1:
                return i + 1
        return length + 1
        
