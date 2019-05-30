class Solution(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums
        

    def reset(self):
        """
        Resets the array to its original configuration and return it.
        :rtype: List[int]
        """
        return self.nums
        

    def shuffle(self):
        """
        Returns a random shuffling of the array.
        :rtype: List[int]
        """
        nums_s = self.nums[:]
        _len = len(self.nums)
        for i in xrange(_len):
            rand = random.randrange(i, _len)
            nums_s[i], nums_s[rand] = nums_s[rand], nums_s[i]
        return nums_s

        


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()
