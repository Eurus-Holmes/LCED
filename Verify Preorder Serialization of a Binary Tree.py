class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        stack = collections.deque()
        for item in preorder.split(','):
            stack.append(item)
            while len(stack)>=3 and stack[-1] == stack[-2] == '#' and stack[-3] != '#':
                stack.pop()
                stack.pop()
                stack.pop()
                stack.append('#')
                
        return len(stack) == 1 and stack[0] == '#'
        
