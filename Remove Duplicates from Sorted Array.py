class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        # The index where the character needs to be placed
        index = 1
        # The index of repeating characters
        start = 0
        for i in range(1, len(nums)):
            if nums[start] != nums[i]:
                nums[index] = nums[i]
                index += 1
                start = i
        return index
        
