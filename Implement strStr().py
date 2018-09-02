class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if not needle:
            return 0
        if not haystack:
            return -1
        i = 0
        needleLength = len(needle)
        while i < len(haystack):
            a = haystack[i:i + needleLength]
            if haystack[i:i + needleLength] == needle:
                return i
            else:
                index = 0
                try:
                    index = needle.rindex(haystack[i + needleLength])
                except Exception:
                    i += needleLength + 1
                i += needleLength-index
        return -1
        
