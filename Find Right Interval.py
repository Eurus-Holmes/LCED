class Solution(object):
    def findRightInterval(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[int]
        """
        start_idx = {}
        for i, (start, end) in enumerate(intervals):
            start_idx[start] = i
        
        # We want to find the minimum start value that is greater than or
        # equal to an interval's end value. We can use binary search if we
        # create a sorted list of start values.
        sorted_starts = sorted(list(start_idx.keys()))
        
        output = []
        for start, end in intervals:
            # If an interval starts where this one ends, we have our answer.
            if end in start_idx:
                output.append(start_idx[end])
            
            # Otherwise search for the insertion point in the sorted list.
            # If the insertion point is at the end of the list, no interval
            # starts after this one ends.
            else:
                idx = bisect.bisect_right(sorted_starts, end)
                if idx == len(sorted_starts):
                    output.append(-1)
                else:
                    min_right = sorted_starts[idx]
                    output.append(start_idx[min_right])
        return output
