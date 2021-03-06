# 原题
在一个数组（存在重复值）中寻找和为特定值的组合。

注意点：

  - 所有数字都是正数
  - 组合中的数字要按照从小到大的顺序
  - 原数组中的数字只可以出现一次
  - 结果集中不能够有重复的组合

例子：

输入: candidates = [10, 1, 2, 7, 6, 1, 5], target = 8 

输出: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

# 解题思路
这道题和 [Combination Sum](https://leetcode.com/problems/combination-sum/description/) 极其相似，主要的区别是Combination Sum中的元素是没有重复的，且每个元素可以使用无限次；
而这题中的元素是有重复的，每个元素最多只能使用一次。
最开始的想法是加下一个元素时不要考虑当前元素，且把结果用集合存储以防止重复的组合出现，但结果超时了。
改用手动把所有与当前元素相等的元素都去掉即可。
