# 原题
Design a data structure that supports the following two operations:
```
void addWord(word)
bool search(word)
```
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A 
. means it can represent any one letter.


注意点：

  - 无

例子：

```
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
```

# 解题思路
基于[208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)的改进。

上个题是，每个节点的子孩子都是一个字典，根据字典查找下一个位置的节点，就像字典一样。同时用isword保存当前是不是一个词（也可能是路径中的点）。

这个题的改进在于对于.符号，要对当前节点的所有孩子进行遍历。为此我们需要定一个新的函数，因为search函数只有要查找的字符串，肯定是以根节点root开始查的，
而我们向后面查的过程中，一定会移动到子节点上，所以需要新的函数。
