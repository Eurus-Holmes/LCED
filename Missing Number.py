class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sum1 = (0 + len(nums)) * (len(nums) + 1) / 2
        sum2 = 0
        for num in nums:
            sum2 += num
        return sum1 - sum2

    
    
# class Solution(object):
#     def missingNumber(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         return sum(range(len(nums)+1)) - sum(nums)
    
    
    
        
