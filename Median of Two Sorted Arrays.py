class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if nums1 is None and nums2 is None:
            return -1.0
        lenA = len(nums1)
        lenB = len(nums2)
        lenn = lenA + lenB;

        indexA,indexB,indexC = 0,0,0
        C = [False for i in xrange(lenn)]
        while indexA < lenA and indexB < lenB:
            if nums1[indexA] < nums2[indexB]:
                C[indexC] = nums1[indexA]
                indexC += 1
                indexA += 1
            else:
                C[indexC] = nums2[indexB]
                indexC += 1
                indexB += 1

        while indexA < lenA:
            C[indexC] = nums1[indexA]
            indexC += 1
            indexA += 1

        while indexB < lenB:
            C[indexC] = nums2[indexB]
            indexC += 1
            indexB += 1

        indexM1 = (lenn - 1) / 2
        indexM2 = lenn / 2

        if (lenn % 2 == 0):
            return (C[indexM1] + C[indexM2]) / 2.0
        else:
            return C[indexM2] / 1.0
