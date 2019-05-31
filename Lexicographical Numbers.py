class Solution(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        if n < 1: return []
        res = []
        for first in xrange(1, 10):
            if first > n: break
            res.append(first)
            self.get_all_number(first,n,res)
        return res
 
    def get_all_number(self, first, n, res):
        for i in xrange(10):
            t = first * 10 + i
            if t <= n:
                res.append(t)
                self.get_all_number(t, n, res)
            else:
                break
        
