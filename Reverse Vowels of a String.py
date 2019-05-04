class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        VOWELS = ('a', 'e', 'i', 'o', 'u')
        size = len(s)
        left, right = 0, size - 1
        ls = list(s)
        while True:
            while left < size and s[left].lower() not in VOWELS:
                left += 1
            while right >= 0 and s[right].lower() not in VOWELS:
                right -= 1
            if left >= right: break
            ls[left], ls[right] = ls[right], ls[left]
            left, right = left + 1, right - 1
        return ''.join(ls)
    
