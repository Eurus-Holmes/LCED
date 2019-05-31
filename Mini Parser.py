# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class Solution(object):
    def deserialize(self, s):
        """
        :type s: str
        :rtype: NestedInteger
        """
        stack = []
        sigma, negmul = None, 1
        for c in s:
            if c == '-':
                negmul = -1
            elif '0' <= c <= '9':
                sigma = (sigma or 0) * 10 + int(c)
            elif c == '[':
                stack.append(NestedInteger())
            else:
                if sigma is not None:
                    stack[-1].add(NestedInteger(sigma * negmul))
                    sigma, negmul = None, 1
                if c == ']':
                    top = stack.pop()
                    if stack: stack[-1].add(top)
                    else: return top
        return NestedInteger((sigma or 0) * negmul)
        
