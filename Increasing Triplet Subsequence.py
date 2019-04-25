class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        a = b = None
        for n in nums:
            if a is None or a>=n:
                a = n
            elif b is None or b>=n:
                b = n
            else:
                return True
            
        return False
        
