class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        return self.dfs(num, [])

    def dfs(self, num_str, path):
        if len(path) >= 3 and  path[-1] != path[-2] + path[-3]:
            return False
        if not num_str and len(path) >= 3:
            return True
        for i in range(len(num_str)):
            curr = num_str[:i+1]
            if (curr[0] == '0' and len(curr) != 1):
                continue
            if self.dfs(num_str[i+1:], path + [int(curr)]):
                return True
        return False

        
