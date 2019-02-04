# 原题
实现字典树，包含插入，查找和前缀查找方法。

注意点：

  - 你可以假设所有的输入只包含小写字母a-z

例子：

```
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
```

# 解题思路
本题考查字典树数据结构的基础知识。

Trie使用孩子表示法存储，TrieNode为字典树的节点，包含属性childs和isWord。

其中childs为dict，存储当前节点的后代节点；isWord为布尔值，表示当前节点是否存储了一个单词。
