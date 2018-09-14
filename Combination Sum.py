class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if not candidates:
            return []
        candidates.sort()
        result = []
        self.combination(candidates, target, [], result)
        return result

    def combination(self, candidates, target, current, result):
        s = sum(current) if current else 0
        if s > target:
            return
        elif s == target:
            result.append(current)
            return
        else:
            for i, v in enumerate(candidates):
                self.combination(candidates[i:], target, current + [v], result)
        
