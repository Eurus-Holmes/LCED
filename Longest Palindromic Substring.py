class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s)==0 or len(s)==1:
            return s
        sub=s[0:1]
        for i in range(len(s)-1):
            def ishuiwen(s,x,y):
                while x>=0 and y<len(s) and s[x]==s[y]:
                    x-=1
                    y+=1
                return s[x+1:y]
            s1=ishuiwen(s,i,i)
            if len(s1)>len(sub):
                sub=s1
            s2=ishuiwen(s,i,i+1)
            if len(s2)>len(sub):
                sub=s2
        return sub
        
