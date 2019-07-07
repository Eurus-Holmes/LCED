"""
# Definition for a QuadTree node.
class Node(object):
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""
class Solution(object):
    def construct(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: Node
        """
        isLeaf = self.isQuadTree(grid)
        _len = len(grid)
        if isLeaf == None:
            mid = _len // 2
            topLeftGrid = [[grid[i][j] for j in range(mid)] for i in range(mid)]
            topRightGrid = [[grid[i][j] for j in range(mid, _len)] for i in range(mid)]
            bottomLeftGrid = [[grid[i][j] for j in range(mid)] for i in range(mid, _len)]
            bottomRightGrid = [[grid[i][j] for j in range(mid, _len)] for i in range(mid, _len)]
            node = Node(True, False, self.construct(topLeftGrid), self.construct(topRightGrid), 
                        self.construct(bottomLeftGrid), self.construct(bottomRightGrid))
        elif isLeaf == False:
            node = Node(False, True, None, None, None, None)
        else:
            node = Node(True, True, None, None, None, None)
        return node
        
    def isQuadTree(self, grid):
        _len = len(grid)
        _sum = 0
        for i in range(_len):
            _sum += sum(grid[i])
        if _sum == _len ** 2:
            return True
        elif _sum == 0:
            return False
        else:
            return None


        
