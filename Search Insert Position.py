class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        length = len(nums)
        start = 0
        end = length
        while start < end:
            mid = (start + end) // 2
            if nums[mid] == target or (nums[mid] > target 
                and (mid == 0 or nums[mid - 1] < target)):
                return mid
            if mid == length - 1 and nums[mid] < target:
                return mid + 1
            if nums[mid] < target:
                start = mid + 1
            else:
                end = mid
        
