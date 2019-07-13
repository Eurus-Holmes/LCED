# 原题
给一组区间，对于每一个区间i，检查是否存在区间j，满足j的起点大于等于i的终点，我们称j在i的“右边"。

对于任意区间i，你需要存储j的最小下标，这意味着区间j拥有最小的起点并且位于i的“右边”。如果j不存在，则存储为-1。将最终结果以数组形式返回。

注意点：

  - 你可以假设区间的终点总是比起点大
  - 你可以假设任意区间的起点都不相同

例子：

```
Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
 

Example 2:

Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
 

Example 3:

Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
```

# 解题思路
### 排序（Sort）+ 二分查找（Binary Search）

按照区间起点排序，然后二分查找即可。
