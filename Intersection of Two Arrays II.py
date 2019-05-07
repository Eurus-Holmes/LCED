class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if len(nums1)>len(nums2):
            nums1, nums2 = nums2, nums1
            
        c = collections.Counter(nums1)
        ans = []
        for x in nums2:
            if c[x]>0:
                ans += x,
                c[x] -= 1
                
        return ans
        
