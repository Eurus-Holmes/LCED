class Solution(object):
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) <=2:
            return False
        third = float('-inf')
        stack = []
        for i in range(len(nums)-1, -1, -1):
            if nums[i] < third:
                return True
            else:
                while stack and stack[-1] < nums[i]:
                    third = stack.pop()
            stack.append(nums[i])
        return False
