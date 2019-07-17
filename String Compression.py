class Solution(object):
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        n = len(chars)
        i , count = 0 , 1
        for j in range(1,n+1):
            if j < n and chars[j] == chars[j-1]:
                count += 1
            else:
                chars[i] = chars[j-1]
                i += 1
                if count > 1:
                    for m in str(count):
                        chars[i] = m
                        i += 1
                count = 1
        return i

        
