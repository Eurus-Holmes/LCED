class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = []
        maxLen = 0
        last = -1
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                if not stack:
                    last = i
                else:
                    stack.pop()
                    if not stack:
                        maxLen = max(maxLen,i - last)
                    else:
                        maxLen = max(maxLen,i - stack[-1])

        return maxLen
        
