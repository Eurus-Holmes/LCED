class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        cnt = 0
        i, j = len(g)-1, len(s)-1
        g, s = sorted(g), sorted(s)
        while min(i, j)>=0:
            if g[i]<=s[j]:
                cnt+=1
                j-=1
            i-=1
            
        return cnt
        
