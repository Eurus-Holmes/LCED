class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums) == 0:
            return []
        nums.sort()
        dp = [1 for i in xrange(len(nums))]
        val = [[i] for i in nums]  #记录所有符合条件的子集
        maxInx = 0
        maxV = 0
        for i, v in enumerate(dp):
            for j in xrange(0, i):
                if nums[i] % nums[j] == 0:
                    if dp[i] < dp[j] + 1:
                        l = val[j][:]
                        l.append(nums[i])
                        val[i] = l
                        dp[i] = dp[j] + 1
                        if maxV < len(val[i]):
                            maxInx = i
                            maxV = len(val[i])
        return val[maxInx]
        
