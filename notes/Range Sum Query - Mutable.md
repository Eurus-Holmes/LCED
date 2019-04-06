# 原题
给定一个整数数组nums，计算下标i与j之间的元素和（i ≤ j），包含边界。

函数update(i, val)将位于下标i的元素值修改为val。

注意点：

  - 无

例子：

```
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
```

# 解题思路
### 解法I：[线段树（Segment Tree）的基础应用](http://bookshadow.com/weblog/2015/08/13/segment-tree-set-1-sum-of-given-range/)

### 解法II：[树状数组（Binary Indexed Tree / Fenwick Tree）](https://www.hrwhisper.me/leetcode-range-sum-query-mutable/)
