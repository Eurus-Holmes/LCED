class Solution(object):
    def canMeasureWater(self, x, y, z):
        """
        :type x: int
        :type y: int
        :type z: int
        :rtype: bool
        """
        if x > y: 
            x, y = y, x
        gcd = self.gcd(x, y)
        if gcd == 0: return z == 0
        return z % gcd == 0 and z <= x + y

    def gcd(self, a, b):
        if a == 0: return b
        return self.gcd(b % a, a)
        
