class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        ans = []
        size1, size2 = len(nums1), len(nums2)
        if size1 * size2 == 0: return ans
        heap = []
        for x in range(size1):
            heapq.heappush(heap, (nums1[x] + nums2[0], x, 0))
        while len(ans) < min(k, size1 * size2):
            sum, i, j = heapq.heappop(heap)
            ans.append((nums1[i], nums2[j]))
            if j + 1 < size2:
                heapq.heappush(heap, (nums1[i] + nums2[j + 1], i, j + 1))
        return ans
        
