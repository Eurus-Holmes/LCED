# 原题
给定每天的股票价格，如果只允许进行一轮交易，也就是买进一次和卖出一次，求所能获得的最大的利润。

注意点：

  - 无

例子:

```
Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
             
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

# 解题思路
这道题只让做一次transaction，那么就需要找到价格最低的时候买，价格最高的时候卖（买价的日期早于卖价的日期）。
从而转化为在最便宜的时候买入，卖价与买价最高的卖出价最大时，就是我们要得到的结果。
因为我们需要买价日期早于卖价日期，所以不用担心后面有一天价格特别低，而之前有一天价格特别高而错过了（这样操作是错误的）。
所以，只许一次遍历数组，维护一个最小买价，和一个最大利润(保证了买在卖前面）即可。
