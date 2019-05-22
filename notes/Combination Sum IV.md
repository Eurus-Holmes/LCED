# 原题
给了一个只包含正整数且不重复的数组，有多少种和为target的方案。

注意点：

  - 无

例子：

```
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
```

# 解题思路

动态规划（Dynamic Programming）

状态转移方程：dp[n] += dp[n-i]

我们需要一个一维数组dp，其中dp[i]表示目标数为i的解的个数，然后我们从1遍历到target，对于每一个数i，遍历nums数组，
如果i>=x, dp[i] += dp[i - x]。
这个也很好理解，比如说对于[1,2,3] 4，这个例子，
当我们在计算dp[3]的时候，3可以拆分为1+x，而x即为dp[2]，
3也可以拆分为2+x，此时x为dp[1]，
3同样可以拆为3+x，此时x为dp[0]，
我们把所有的情况加起来就是组成3的所有情况了。

算dp[n]的时候遍历num[1] to num[n] index = i

dp[n] = dp[n] + dp[n-i]

```
比如4
从1遍历到4
1<4
dp[4] = dp[4] + dp[4-1]
```
