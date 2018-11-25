# 原题
给定每天的股票价格，如果允许进行多次交易，即可以多次买入和卖出，但手中最多只能持有一支股票，在再次买入的时候必须将之前的股票卖出，求能获取的最大利润。

注意点：

  - 无

例子:

```
Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
             
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
先找到递减的局部最低点，再找到递增的局部最高点，算一次加和，然后再这么找，这样就能保证买卖不会在同一天了。
