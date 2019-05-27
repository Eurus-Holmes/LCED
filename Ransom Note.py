class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        ransomCnt = collections.Counter(ransomNote)
        magazineCnt = collections.Counter(magazine)
        return not ransomCnt - magazineCnt
        
