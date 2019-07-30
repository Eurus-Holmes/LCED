class Solution(object):
    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        N, self.nums = len(nums), nums
        for i in range(N):
            slow = i
            fast = self.nextpos(slow)
            while nums[fast]*nums[i]>0 and nums[self.nextpos(fast)]*nums[i]>0:
                if fast == slow:
                    if slow == self.nextpos(slow):
                        break
                    return True
                slow = self.nextpos(slow)
                fast = self.nextpos(self.nextpos(fast))
        return False
        
        
    def nextpos(self, index):
        N = len(self.nums)
        return (index+self.nums[index]+N)%N
        
