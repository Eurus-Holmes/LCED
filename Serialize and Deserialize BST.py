# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root: return ''
        left = self.serialize(root.left)
        right = self.serialize(root.right)
        ans = str(root.val)
        if left: ans += ',' + left
        if right: ans += ',' + right
        return ans
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data: return None
        nstack, rstack = [], [0x7FFFFFFF]
        for val in map(int, data.split(',')):
            node = TreeNode(val)
            if nstack:
                if val < nstack[-1].val:
                    nstack[-1].left = node
                    rstack.append(nstack[-1].val)
                else:
                    while val > rstack[-1]:
                        while nstack[-1].val > nstack[-2].val:
                            nstack.pop()
                        rstack.pop()
                        nstack.pop()
                    nstack[-1].right = node
            nstack.append(node)
        return nstack[0]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
