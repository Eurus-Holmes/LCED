class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        result = []
        length = len(nums)

        start = 0
        end = length
        while start < end:
            mid = (start + end) // 2
            if nums[mid] == target and (mid == 0 or nums[mid - 1] != target):
                result.append(mid)
                break
            if nums[mid] < target:
                start = mid + 1
            else:
                end = mid
        if not result:
            return [-1, -1]

        end = length
        while start < end:
            mid = (start + end) // 2
            if nums[mid] == target and (mid == length - 1 or nums[mid + 1] != target):
                result.append(mid)
                break
            if nums[mid] <= target:
                start = mid + 1
            else:
                end = mid

        return result
        
