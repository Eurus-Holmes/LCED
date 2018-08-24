class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        i = 0
        result = 0
        # Init the distance between result and target with a very large number
        distance = pow(2, 32) - 1
        for i in range(len(nums)):
            j = i + 1
            k = len(nums) - 1
            while j < k:
                l = [nums[i], nums[j], nums[k]]
                if sum(l) == target:
                    return target
                if abs(sum(l) - target) < distance:
                    result = sum(l)
                    distance = abs(sum(l) - target)
                elif sum(l) > target:
                    k -= 1
                else:
                    j += 1
        return result
        
