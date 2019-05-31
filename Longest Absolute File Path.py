# class Solution(object):
#     def lengthLongestPath(self, input):
#         """
#         :type input: str
#         :rtype: int
#         """
#         ans = lengthSum = 0
#         stack = [(-1, 0)]
#         for p in input.split('\n'):
#             depth = p.count('\t')
#             name = p.replace('\t', '')
#             topDepth, topLength = stack[-1]
#             while depth <= topDepth:
#                 stack.pop()
#                 lengthSum -= topLength
#                 topDepth, topLength = stack[-1]
#             length = len(name) + (depth > 0)
#             lengthSum += length
#             stack.append((depth, length))
#             if name.count('.'):
#                 ans = max(ans, lengthSum)
#         return ans

class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        maxlen = 0
        pathlen = {0: 0}
        for line in input.splitlines():
            name = line.lstrip('\t')
            depth = len(line) - len(name)
            if '.' in name:
                maxlen = max(maxlen, pathlen[depth] + len(name))
            else:
                pathlen[depth + 1] = pathlen[depth] + len(name) + 1
        return maxlen
