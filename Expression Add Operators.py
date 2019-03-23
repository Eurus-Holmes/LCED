class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        results = []
        self.opRecur(num, target, 0, 0, "", results)
        return results
        
    def opRecur(self, num, target, lastOp, result, expression, results):
        if len(num) == 0:
            if target == result:
                results.append(expression)
            return
        
        for i in range(1, len(num) + 1):
            cur = num[:i]
            if len(cur) > 1 and cur[0] == "0":
                continue
            rest = num[i:]
            curV = int(cur)
            if len(expression) == 0:
                self.opRecur(rest, target, curV, curV, expression + cur, results)
            else:
                self.opRecur(rest, target, curV, result + curV, expression + "+" + cur, results)
                self.opRecur(rest, target, -curV, result - curV, expression + "-" + cur, results)
                self.opRecur(rest, target, lastOp * curV, result - lastOp + lastOp * curV, expression + "*" + cur, results)
        
