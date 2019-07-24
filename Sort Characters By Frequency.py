class Solution(object):
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        count = collections.Counter(s).most_common()
        res = ''
        for c, v in count:
            res += c * v
        return res
