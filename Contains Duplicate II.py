class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        d={}
        for i in range(len(nums)):
            if nums[i] in d:
                j = d[nums[i]]
                if i-j <= k:
                    return True
            d[nums[i]] = i
        return False
        
