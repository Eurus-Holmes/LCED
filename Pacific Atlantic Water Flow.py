class Solution(object):
    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        m = len(matrix)
        n = len(matrix[0]) if m else 0
        if m * n == 0: return []
        topEdge = [(0, y) for y in range(n)]
        leftEdge = [(x, 0) for x in range(m)]
        pacific = set(topEdge + leftEdge)
        bottomEdge = [(m - 1, y) for y in range(n)]
        rightEdge = [(x, n - 1) for x in range(m)]
        atlantic = set(bottomEdge + rightEdge)
        def bfs(vset):
            dz = zip((1, 0, -1, 0), (0, 1, 0, -1))
            queue = list(vset)
            while queue:
                hx, hy = queue.pop(0)
                for dx, dy in dz:
                    nx, ny = hx + dx, hy + dy
                    if 0 <= nx < m and 0 <= ny < n:
                        if matrix[nx][ny] >= matrix[hx][hy]:
                            if (nx, ny) not in vset:
                                queue.append((nx, ny))
                                vset.add((nx, ny))
        bfs(pacific)
        bfs(atlantic)
        result = pacific & atlantic
        return map(list, result)
        
