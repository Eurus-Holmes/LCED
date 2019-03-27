class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low, high = 1, len(nums)-1
        while low <= high:
            mid = (low+high)/2
            cnt = sum(x<=mid for x in nums)
            if cnt > mid:
                high = mid - 1
            else:
                low = mid + 1
        return low
    
    

    
    
    
    
# Interesting Solution!

# class Solution(object):
#     def findDuplicate(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         for i in range(len(nums)):
# 	        if nums[abs(nums[i])]>0:
# 		        nums[abs(nums[i])]=-nums[abs(nums[i])]
# 	        else:
# 		        return abs(nums[i])
        
    
    
    
    
    
