class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        p_index, s_index, last_s_index, last_p_index = 0, 0, -1, -1
        while s_index < len(s):
            # Normal match including '?'
            if p_index < len(p) and (s[s_index] == p[p_index] or p[p_index] == '?'):
                s_index += 1
                p_index += 1
            # Match with '*'
            elif p_index < len(p) and p[p_index] == '*':
                p_index += 1
                last_s_index = s_index
                last_p_index = p_index
            # Not match, but there is a '*' before
            elif last_p_index != -1:
                last_s_index += 1
                s_index = last_s_index
                p_index = last_p_index
            # Not match and there is no '*' before
            else:
                return False
        # Check if there is still character except '*' in the pattern
        while p_index < len(p) and p[p_index] == '*':
            p_index += 1
        # If finish scanning both string and pattern, then it matches well
        return p_index == len(p)
  
