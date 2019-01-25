# 原题

```
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from 
robbing each of them is that adjacent houses have security system connected and it will automatically 
contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

```

注意点：

  - 无

例子:

```
Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
             
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
```

# 解题思路
一般来说，给定一个规则，让我们求任意状态下的解，都是用动态规划。
这里的规则是劫匪不能同时抢劫相邻的屋子，即我们在累加时，只有两种选择：

  1. 如果选择了抢劫上一个屋子，那么就不能抢劫当前的屋子，所以最大收益就是抢劫上一个屋子的收益

  2. 如果选择抢劫当前屋子，就不能抢劫上一个屋子，所以最大收益是到上一个屋子的上一个屋子为止的最大收益，加上当前屋子里有的钱

所以，我们只要判断一下两个里面哪个大就行了，同时也是我们的递推式。
另外我们可以做一点优化，本来我们是要用一个dp数组来保存之前的结果的。
但实际上我们只需要上一次和上上次的结果，所以可以用两个变量就行了。

### 复杂度
时间 O(N) 空间 O(1)
