class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums)==0:
            return []
        if len(nums)==1:
            return [nums]
        nums.sort()
        res=[]
        previousnum=None
        for i in range(len(nums)):
            if nums[i]==previousnum:
                continue
            previousnum=nums[i]
            for j in self.permuteUnique(nums[:i]+nums[i+1:]):
                res.append([nums[i]]+j)
        return res
