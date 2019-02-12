# 原题
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

注意点：

  - 所有数字都是正数
  - 组合中的数字要按照从小到大的顺序
  - 原数组中的数字只可以出现一次
  - 结果集中不能够有重复的组合

例子：

```
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
```

# 解题思路
The goal of this problem is to choose k numbers from [1, 9] inclusive such that they sum up to n.
One way to think about this problem is: how many ways can we choose k numbers (w/o repeat) from [1,9] 
such that they add up to n.

The base case is if the sum of the numbers chosen is equal to n, and the number of numbers chosen is k.
The code is presented below.

```python
class Solution:
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        
        upper bound is 9 choose k 
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
```

The solution will have the following recurrence:
T(n) = T(n - 1) + O(n^2).
This is because at every subproble, we have an outter loop that takes n time and within the loop, 
we're making a copy of the list which also can take up to n time. And at each sub problem, we make it smaller by 1.

Thus, the worst case for the running time of this problem would be O(n^3), since at each sub problem we take O(n^2) 
and there are n sub problems.

The space complexity is at worst O(k).
