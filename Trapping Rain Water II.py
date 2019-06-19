class Solution(object):
    def trapRainWater(self, heightMap):
        """
        :type heightMap: List[List[int]]
        :rtype: int
        """
        m = len(heightMap)
        n = len(heightMap[0]) if m else 0
        peakMap = [[float('inf')] * n for _ in range(m)]
        queue = []

        for x in range(m):  # 把矩形的四边入队
            for y in range(n):
                if x in (0, m - 1) or y in (0, n - 1):
                    peakMap[x][y] = heightMap[x][y]
                    queue.append((x, y))

        while queue:
            x, y = queue.pop(0)  # 出队一个位置，并以这个位置为基础，更新四周的位置。
            for dx, dy in zip((1, 0, -1, 0), (0, 1, 0, -1)):  # 下，右，上，左 四个方向
                nx, ny = x + dx, y + dy
                if nx <= 0 or nx >= m - 1 or ny <= 0 or ny >= n - 1: continue  # 在边界上，和在边界之外，不做操作
                limit = max(peakMap[x][y], heightMap[nx][ny])
                if peakMap[nx][ny] > limit:
                    peakMap[nx][ny] = limit
                    queue.append((nx, ny))
        return sum(peakMap[x][y] - heightMap[x][y] for x in range(m) for y in range(n))

        
