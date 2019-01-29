class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        num_dict={}
        
        while True:
            num_dict[n] = True
            sum = 0
            while(n>0):
                sum += (n%10)*(n%10)
                n /= 10
            
            if sum == 1:
                return True
            elif sum in num_dict:
                return False
            else:
                n = sum
