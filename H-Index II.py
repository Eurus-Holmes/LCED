class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        N = len(citations)
        h = 0
        l, r = 0, N-1
        while l <= r:
            mid = l + (r-l)/2
            h = max(h, min(citations[mid], N-mid))
            if citations[mid] < N-mid:
                l = mid + 1
            else:
                r = mid - 1
        return h
        
