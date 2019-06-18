class Solution(object):
    def findNthDigit(self, n):
        """
        :type n: int
        :rtype: int
        """
        _len = 1
        cnt = 9
        start = 1
        while n > _len*cnt:
            n -= _len*cnt
            _len += 1
            cnt *= 10
            start *= 10
        start += (n-1)/_len 
        return int(str(start)[(n-1)%_len])
        
