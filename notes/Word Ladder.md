# 原题
给定一个起始字符串和一个目标字符串，现在将起始字符串按照特定的变换规则转换为目标字符串，求最少要进行多少次转换。转换规则为每次只能改变字符串中的一个字符，且每次转换后的字符串都要在给定的字符串集合中。

注意点：

  - 如果无法完成转换则返回0
  - 所有给出的字符串的长度都相等
  - 所有的字符都为小写字母

例子:

```
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
```

# 解题思路
这是一道bfs的题，开始突然反应不过来。 
可以想象成一棵树，根节点是start字符串，第二层是所有的和它相差一个字母的字符串
（之前出现过的，之后就没有必要出现了，因为出现的话，也是abc变成bbc又变回abs，没有意义），
用一个hashmap来保存每一个节点的所处的层数，还需要一个队列来实现广度优先搜索，
因为是从顶层到底层来遍历的，所以发现等于end的时候的层数值就是最小的，返回即可。
