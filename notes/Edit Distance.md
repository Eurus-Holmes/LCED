# 原题
求两个字符串之间的最短编辑距离，即原来的字符串至少要经过多少次操作才能够变成目标字符串，操作包括删除一个字符、插入一个字符、更新一个字符。

注意点：

  - 无

例子：

```
Input: word1 = "horse", word2 = "ros"

Output: 3

Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

# 解题思路
### 动态规划

动态数组dp[word1.length+1][word2.length+1]

dp[i][j]表示从word1前i个字符转换到word2前j个字符最少的步骤数。

假设word1现在遍历到字符x，word2遍历到字符y（word1当前遍历到的长度为i，word2为j）。

以下两种可能性：

1. x==y，那么不用做任何编辑操作，所以dp[i][j] = dp[i-1][j-1]

2. x != y

   (1) 在word1插入y， 那么dp[i][j] = dp[i][j-1] + 1

   (2) 在word1删除x， 那么dp[i][j] = dp[i-1][j] + 1

   (3) 把word1中的x用y来替换，那么dp[i][j] = dp[i-1][j-1] + 1

 最少的步骤就是取这三个中的最小值。

最后返回 dp[word1.length+1][word2.length+1] 即可。
