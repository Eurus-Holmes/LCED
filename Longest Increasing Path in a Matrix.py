class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        h = len(matrix)
        if h == 0: return 0
        w = len(matrix[0])
        dp = [[1] * w for x in range(h)]
        slist = sorted([(i, j, val)
                  for i, row in enumerate(matrix)
                  for j, val in enumerate(row)], 
                  key=operator.itemgetter(2))
        for x, y, val in slist:
            for dx, dy in zip([1, 0, -1, 0], [0, 1, 0, -1]):
                nx, ny = x + dx, y + dy
                if 0 <= nx < h and 0 <= ny < w and matrix[nx][ny] > matrix[x][y]:
                    dp[nx][ny] = max(dp[nx][ny], dp[x][y] + 1)
        return max([max(x) for x in dp])
        
