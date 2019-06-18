class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        if len(num) == k:
            return "0"
        stack = []
        for n in num:
            while stack and k and int(stack[-1])>int(n):
                stack.pop()
                k -= 1
            stack.append(n)
            
        while k:
            stack.pop()
            k -= 1
        
        if not stack:
            return "0"
        
        return str(int("".join(stack)))
        
