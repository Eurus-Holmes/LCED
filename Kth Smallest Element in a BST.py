# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.k = k
        res = []
        self.helper(root,res)
        return res[0]
    
    def helper(self, root, res):
        if not root:
            return

        self.helper(root.left, res)
        self.k -= 1
        if self.k == 0:
            res.append(root.val)
            return
        self.helper(root.right, res)
        
