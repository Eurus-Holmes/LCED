class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        if not intervals: return 0
        intervals.sort(key = lambda interval:interval[0])
        last = 0
        res = 0
        for i in range(1, len(intervals)):
            if intervals[last][-1] > intervals[i][0]:
                if intervals[i][-1] < intervals[last][-1]:
                    last = i
                res += 1
            else:
                last = i
        return res

        
