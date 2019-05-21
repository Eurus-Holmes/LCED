class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)
        ans, i, j = 1, 1, 0
        while i < n:
            if nums[j] < nums[i]:
                ans+=1
                while i+1 < n and nums[i+1] >= nums[i]:
                    i += 1
            elif nums[j] > nums[i]:
                ans+=1
                while i+1 < n and nums[i+1] <= nums[i]:
                    i += 1
                    
            i, j = i+1, i
        return ans
        
