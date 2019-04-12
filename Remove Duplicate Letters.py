class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        counter = collections.Counter(s)
        resultSet = set()
        stack = list()
        for c in s:
            counter[c] -= 1
            if c in resultSet:
                continue
            while stack and stack[-1] > c and counter[stack[-1]]:
                resultSet.remove(stack.pop())
            resultSet.add(c)
            stack.append(c)
        return ''.join(stack)
        
