class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        counter = 0
        longest = 0
        reach = 0
        for i in range(length):
            if longest < i:
                counter += 1
                longest = reach
            reach = max(reach, nums[i] + i)
        return counter
    
