原题

给定每天的股票价格，如果最多允许两次交易，但手中最多只能持有一支股票，在再次买入的时候必须将之前的股票卖出，求能获取的最大利润。

注意点：

  - 无

例子:

```
Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
             
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
             
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

# 解题思路
根据题目要求，最多进行两次买卖股票，而且手中不能有2只股票，就是不能连续两次买入操作。

所以，两次交易必须是分布在2各区间内，也就是动作为：买入卖出，买入卖出。

进而，我们可以划分为2个区间[0,i]和[i,len-1]，i可以取0~len-1。

那么两次买卖的最大利润为：在两个区间的最大利益和的最大利润。

一次划分的最大利益为：Profit[i] = MaxProfit(区间[0,i]) + MaxProfit(区间[i,len-1]);

最终的最大利润为：MaxProfit(Profit[0], Profit[1], Profit[2], ... , Profit[len-1])。
