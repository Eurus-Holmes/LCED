class Solution(object):
    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        for i in range(1,n+1):
            n = str(i)
            if i % 15 == 0:
                n = "FizzBuzz"
            elif i % 3 == 0:
                n = "Fizz"
            elif i % 5 == 0:
                n = "Buzz"
            ans.append(n)
        return ans


# class Solution(object):
#     def fizzBuzz(self, n):
#         """
#         :type n: int
#         :rtype: List[str]
#         """
#         return ['Fizz' * (not x % 3) + 'Buzz' * (not x % 5) or str(x) for x in range(1, n + 1)]
