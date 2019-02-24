# 原题
给定一组排好序且无重复的整数，返回整数范围的汇总。

注意点：

  - 无

例子：

```
Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
```

# 解题思路
将逐一递增的整数序列化简为（起点->终点）即可。
