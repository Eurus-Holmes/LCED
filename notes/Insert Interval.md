# 原题
给出多个不重合的数据区段，现在插入一个新的数据区段，有重合的区段要进行合并。

注意点：

  - 所给的区段已经按照起始位置进行排序

例子：

输入: intervals = [2,6],[8,10],[15,18]， newInterval = [13,16]

输出: [2,6],[8,10],[13,18]

# 解题思路
最简单的方式就是复用 [Merge Intervals](https://leetcode.com/problems/merge-intervals/description/) 的方法，
只需先将新的数据区段加入集合即可，但这样效率不高。

既然原来的数据段是有序且不重合的，那么我们只需要找到哪些数据段与新的数据段重合，把这些数据段合并，并加上它左右的数据段即可。
具体分情况讨论：

  - 遍历每一个已给出的interval，
  - 当当前的interval的end小于newInterval的start时，说明新的区间在当前遍历到的区间的后面，并且没有重叠，所以res添加当前的interval；
  - 当当前的interval的start大于newInterval的end时，说明新的区间比当前遍历到的区间要前面，并且也没有重叠，所以把newInterval添加到res里，并更新newInterval为当前的interval； 
  - 当当前的interval与newInterval有重叠时，merge interval并更新新的newInterval为merge后的。
