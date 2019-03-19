# class Solution(object):
#     def hIndex(self, citations):
#         """
#         :type citations: List[int]
#         :rtype: int
#         """
#         N = len(citations)
#         citations.sort()
#         h = 0
#         for i, c in enumerate(citations):
#             h = max(h, min(N-i, c))
#         return h




class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        N = len(citations)
        citations.sort()
        l, r = 0, N-1
        h = 0
        while l <= r:
            mid = l + (r-l)/2
            h = max(h, min(citations[mid], N-mid))
            if citations[mid] < N-mid:
                l = mid + 1
            else:
                r = mid - 1
        return h
