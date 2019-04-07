# 原题
给定一个数组，第i个元素代表某只股票在第i天的价格。

设计一个算法计算最大收益。你可以完成多次交易（亦即，多次买入、卖出同一只股票）

注意点：

  - 你不可以在同一时间参与多个交易（亦即，在买入股票之前必须卖出）。
  - 在卖出股票之后，你不可以在第二天马上买入。（亦即，需要一天的冷却（CD）时间）

例子：

```
Input: [1,2,3,0,2]

Output: 3 

Explanation: transactions = [buy, sell, cooldown, buy, sell]
```

# 解题思路
### 动态规划（Dynamic Programming）

时间复杂度：O(n)


#### 解法I：

引入辅助数组sells和buys

```
sells[i]表示在第i天卖出股票所能获得的最大累积收益
buys[i]表示在第i天买入股票所能获得的最大累积收益

初始化令sells[0] = 0，buys[0] = -prices[0]
第i天交易时获得的累计收益只与第i-1天与第i-2天有关

记第i天与第i-1天的价格差：delta = price[i] - price[i - 1]

状态转移方程为：

sells[i] = max(buys[i - 1] + prices[i], sells[i - 1] + delta) 
buys[i] = max(sells[i - 2] - prices[i], buys[i - 1] - delta)

上述方程的含义为：

第i天卖出的最大累积收益 = max(第i-1天买入~第i天卖出的最大累积收益, 第i-1天卖出后反悔~改为第i天卖出的最大累积收益)
第i天买入的最大累积收益 = max(第i-2天卖出~第i天买入的最大累积收益, 第i-1天买入后反悔~改为第i天买入的最大累积收益)

而实际上：

第i-1天卖出后反悔，改为第i天卖出 等价于 第i-1天持有股票，第i天再卖出
第i-1天买入后反悔，改为第i天买入 等价于 第i-1天没有股票，第i天再买入
所求的最大收益为max(sells)。显然，卖出股票时才可能获得收益。
```

```python
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        size = len(prices)
        if not size:
            return 0
        buys = [None] * size
        sells = [None] * size
        sells[0], buys[0] = 0, -prices[0]
        for x in range(1, size):
            delta = prices[x] - prices[x - 1]
            sells[x] = max(buys[x - 1] + prices[x], sells[x - 1] + delta)
            buys[x] = max(buys[x - 1] - delta, \
                          sells[x - 2] - prices[x] if x > 1 else None)
        return max(sells)
```

#### 解法II：

引入辅助数组sells和buys

```
sells[i]表示在第i天不持有股票所能获得的最大累计收益
buys[i]表示在第i天持有股票所能获得的最大累计收益

初始化数组：
sells[0] = 0
sells[1] = max(0, prices[1] - prices[0])
buys[0] = -prices[0]
buys[1] = max(-prices[0], -prices[1])

状态转移方程：

sells[i] = max(sells[i - 1], buys[i - 1] + prices[i])
buys[i] = max(buys[i - 1], sells[i - 2] - prices[i])

所求最大收益为sells[-1]
```

```python
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        size = len(prices)
        if size < 2:
            return 0
        buys = [None] * size
        sells = [None] * size
        sells[0], sells[1] = 0, max(0, prices[1] - prices[0])
        buys[0], buys[1] = -prices[0], max(-prices[0], -prices[1])
        for x in range(2, size):
            sells[x] = max(sells[x - 1], buys[x - 1] + prices[x])
            buys[x] = max(buys[x - 1], sells[x - 2] - prices[x])
        return sells[-1]
```
