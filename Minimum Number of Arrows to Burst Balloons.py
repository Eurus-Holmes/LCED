class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        ans = 0
        emin = MAXINT = 0x7FFFFFFF
        for s, e in sorted(points):
            if emin < s:
                ans += 1
                emin = MAXINT
            emin = min(emin, e)
        return ans + bool(points)
