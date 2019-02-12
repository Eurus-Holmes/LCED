class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        out = []
        nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        
        def helper(nums, current_nums, curr_sum, out):
            if curr_sum == n and len(current_nums) == k:
                out.append(current_nums)
                return
            
            for i, val in enumerate(nums):
                new_sum = curr_sum + val
                if new_sum > n:
                    return
                new_nums = nums[i + 1:]
                new_current = current_nums +[val]
                helper(new_nums, new_current, new_sum, out)
        
        helper(nums, [], 0, out)
        return out
