# 原题

这个是[198. House Robber](https://leetcode.com/problems/house-robber/)的拓展。
本题目里面的房间是一个环的，也就是说第一个房子和最后一个房子是相邻的。在这种情况下，相邻的两个房子不能一起偷，求能偷到的金额的最大值。

注意点：

  - 无

例子:

```
Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
             
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
```

# 解题思路
这个题多了环的条件，在这个约束下就多了个不同时偷第一个和最后一个就可以了。
所以，两种偷的情况：第一种不偷最后一个房间，第二种不偷第一个房间，求这两种偷法能获得的最大值。
所以只多了一个切片的过程。

状态转移方程仍然是：

```
dp[0] = num[0] （当i=0时） 
dp[1] = max(num[0], num[1]) （当i=1时） 
dp[i] = max(num[i] + dp[i - 2], dp[i - 1]) （当i !=0 and i != 1时）
```

第三个式子就是当前的房间偷的情况和不偷情况下的最大值。

### 复杂度
时间 O(N) 空间 O(N)
