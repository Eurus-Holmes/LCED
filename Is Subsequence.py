class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        queue = collections.deque(s)
        for c in t:
            if not queue: return True
            if c == queue[0]:
                queue.popleft()
        return not queue


# class Solution(object):
#     def isSubsequence(self, s, t):
#         """
#         :type s: str
#         :type t: str
#         :rtype: bool
#         """
#         si, ti = 0, 0
#         while si < len(s) and ti < len(t):
#             if t[ti] == s[si]:
#                 si += 1
#             ti += 1
#         return si == len(s)
