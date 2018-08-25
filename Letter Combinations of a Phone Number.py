class Solution(object):
    digit2letters = {
        '2': "abc",
        '3': "def",
        '4': "ghi",
        '5': "jkl",
        '6': "mno",
        '7': "pqrs",
        '8': "tuv",
        '9': "wxyz",
    }

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if not digits:
            return []
        result = []
        self.dfs(digits, "", result)
        return result

    def dfs(self, digits, current, result):
        if not digits:
            result.append(current)
            return
        for c in self.digit2letters[digits[0]]:
            self.dfs(digits[1:], current + c, result)

        
