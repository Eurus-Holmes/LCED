# 原题
将所含字母相同，但排列顺序不同的字符串归并到一起。

注意点：

  - 所有输入的字符都是小写的
  

例子：

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]

输出: [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]

# 解题思路
map容器将每一个字符串排过序之后作为key，value就保存所有的具有相同字母的字符串。