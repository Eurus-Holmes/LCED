# 原题
计算某个研究人员的影响因子。影响因子的计算方式是有h篇影响力至少为h的论文。
影响因子是衡量作者生产力和影响力的方式，判断了他有多少篇影响力很大的论文。

**difference: sorted in ascending order**


注意点：

  - 

例子：

```
Input: citations = [0,1,3,5,6]

Output: 3 

Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
```

# 解题思路


### 二分法

时间复杂度是O(NlogN + logN)，空间复杂度是O(N)。


