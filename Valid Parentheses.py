class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) % 2 == 1:
            return False
        stack = []
        left = ("(", "[", "{")
        right = (")", "]", "}")
        zip(left,right)
        for v in s:
            if v in left:
                stack.append(v)
            else:
                if not stack:
                    return False
                p = stack.pop()
                if left.index(p) != right.index(v):
                    return False
        return len(stack) == 0
