"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        res = []
        que = collections.deque()
        que.append(root)
        while que:
            level = []
            size = len(que)
            for _ in range(size):
                node = que.popleft()
                if not node:
                    continue
                level.append(node.val)
                for child in node.children:
                    que.append(child)
            if level:
                res.append(level)
        return res

        
