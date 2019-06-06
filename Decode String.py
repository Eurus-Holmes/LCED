class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        curnum = 0
        curstring = ''
        stack = []
        for char in s:
            if char == '[':
                stack.append(curstring)
                stack.append(curnum)
                curstring = ''
                curnum = 0
            elif char == ']':
                prenum = stack.pop()
                prestring = stack.pop()
                curstring = prestring + prenum * curstring
            elif char.isdigit():
                curnum = curnum * 10 + int(char)
            else:
                curstring += char
        return curstring

        
