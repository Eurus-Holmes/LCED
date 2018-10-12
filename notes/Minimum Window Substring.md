# 原题
给定两个字符串S和T，要求在O(n)的时间内找到包含T中所有字符的S的最短子字符串。

注意点：

  - 如果不存在满足要求的子字符串，则返回""
  - 如果存在多个子字符串满足要求，可以保证其中只有一个最短的

例子：

输入: s = "ADOBECODEBANC", t = "ABC"

输出: "BANC"

# 解题思路
这道题也是用滑动窗口的思想，
思想跟 [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/)
是一样的，同样是利用HashMap来存Dict，然后来遍历整个母串。

因为这里是要求最短的包含子串的字符串，所以中间是可以允许有非子串字符的，当遇见非子串字符而count又没到子串长度时，可以继续走。

当count达到子串长度，说明之前遍历的这些有符合条件的串，
用一个pre指针帮忙找，pre指针帮忙找第一个在HashMap中存过的，
并且找到后给计数加1后的总计数是大于0的，判断是否为全局最小长度，
如果是，更新返回字符串res，更新最小长度，如果不是，继续找。
