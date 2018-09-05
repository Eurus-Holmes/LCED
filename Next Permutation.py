class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        length = len(nums)

        targetIndex = 0
        changeIndex = 0
        for i in range(length - 1, 0, -1):
            if nums[i] > nums[i - 1]:
                targetIndex = i - 1
                break
        for i in range(length - 1, -1, -1):
            if nums[i] > nums[targetIndex]:
                changeIndex = i
                break
        nums[targetIndex], nums[changeIndex] = nums[changeIndex], nums[targetIndex]
        if targetIndex == changeIndex == 0:
            nums.reverse()
        else:
            nums[targetIndex + 1:] = reversed(nums[targetIndex + 1:])
