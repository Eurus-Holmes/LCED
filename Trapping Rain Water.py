class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if not height:
            return 0
        length = len(height)
        maxh = [0 for __ in range(length)]
        h = height[length - 1]
        for i in range(length - 2, -1, -1):
            maxh[i] = h
            h = max(h, height[i])

        h = height[0]
        result = 0
        for i in range(1, length - 1):
            h = max(h, height[i])
            result += max(0, min(h, maxh[i]) - height[i])
        return result
