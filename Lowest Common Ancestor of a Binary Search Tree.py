# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        pointer = root
        while pointer:
            if p.val > pointer.val and q.val > pointer.val:
                pointer = pointer.right
            elif p.val < pointer.val and q.val < pointer.val:
                pointer = pointer.left
            else:
                return pointer
        
