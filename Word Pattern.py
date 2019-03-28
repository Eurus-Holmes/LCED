# class Solution(object):
#     def wordPattern(self, pattern, str):
#         """
#         :type pattern: str
#         :type str: str
#         :rtype: bool
#         """
#         s = pattern
#         t = str.split()
#         return map(s.find, s) == map(t.index, t)
        
        
        
        
        
# class Solution(object):
#     def wordPattern(self, pattern, str):
#         """
#         :type pattern: str
#         :type str: str
#         :rtype: bool
#         """
#         s = pattern
#         t = str.split()
#         return len(set(zip(s, t))) == len(set(s)) == len(set(t)) and len(s) == len(t)
        
        
        
      
    
    
    
        
class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        words = str.split()
        if len(pattern) != len(words):
            return False
        ptnDict, wordDict = {}, {}
        for ptn, word in zip(pattern, words):
            if ptn not in ptnDict:
                ptnDict[ptn] = word
            if word not in wordDict:
                wordDict[word] = ptn
            if wordDict[word] != ptn or ptnDict[ptn] != word:
                return False
        return True
