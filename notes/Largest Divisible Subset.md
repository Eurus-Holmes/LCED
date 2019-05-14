# 原题
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements 
in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

注意点：

  - 无

例子：

```
Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
```

# 解题思路
leetcode里面有很多这样类似的题目，本题是求能够整除的，还有求依次递增的，一增一减的等等，都是万变不离其宗。
对于这一类题目，我都是采用动态规划的算法。这题怎么解呢？
首先对nums按升序排序，然后创建一个dp数组，dp[i]表示从nums[0]~nums[i]区间符合题目条件的子集的最大长度（注意，子集中nums[i]是必定包含的），
里面的每个元素赋初始值为1。那个我们很容易可以得到递推表达式:在j = [0,i-1]区间内，得到满足nums[i] % nums[j] 条件的max{dp[j]},
那么dp[i] = dp[j] + 1。同时，因为题目要求的不是输出最大长度，而是输出最大子集，因此，再用一个数组记录遍历过程中符合条件的子集即可。
