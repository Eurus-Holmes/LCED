# 原题


Say you have an array for which the $i^{th}$ element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

注意点：

  - 无

例子:

```
Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
```

# 解题思路
[reference](http://blog.csdn.net/linhuanmars/article/details/23236995)

global[i][j] means at day i with max j transactions, maximum profit. 

local[i][j] means at day i with max j transactions, and last transaction happened at day i, maximum profit 

global[i][j] = max(global[i-1][j], local[i][j]),  diff means last profit.

local[i][j] = max(global[i-1][j] + max(diff,0), local[i-1][j] + diff)
