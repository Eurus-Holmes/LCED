# 原题
给定一个起始字符串和一个目标字符串，现在将起始字符串按照特定的变换规则转换为目标字符串，求所有转换次数最少的转换过程。转换规则为每次只能改变字符串中的一个字符，且每次转换后的字符串都要在给定的字符串集合中。

注意点：

  - 所有给出的字符串的长度都相等
  - 所有的字符都为小写字母

例子:

```
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
```

# 解题思路
```
* Approach: BFS + DFS
 * 答案要求最短路径，因此我们想到了使用 BFS，
 * 但是又需要我们输出所有路径，因此我们还需要使用 DFS 进行遍历。
 *
 * 具体的做法为：
 * 先使用 BFS 搜索出 beginWord 到 endWord 之间最短的路径。
 * 并在搜索的过程中建立好 关系图，即每个结点对应的下一层节点（邻居）分别为哪些。
 * 同时为了在 DFS 时，能够知道遍历的是否是最短路径，我们还需要保存各个 单词节点 到 beginWord 的距离。
 * 有了以上信息之后，我们再使用 DFS 从 beginWord 开始
 * 遍历由 BFS 建立好的关系图，得到所有的最短路径即可。
 *
 * 不少人会问，为什么我们需要使用到 BFS 呢？直接使用 DFS 枚举不好吗？
 * 原因是，直接使用 DFS 暴力查找的话会耗费掉许多时间。
 * 比如 beginWord 和 endWord 之间距离只有 3，但是整张图非常大（两个点距离有1000的那种），
 * 这个时候如果使用 DFS，毫无疑问会超时。
 * 而如果实现使用 BFS 对图进行处理，构建出我们需要的那个部分，然后再 DFS 就可以节省大量的时间了。
 * 
 * 本题还有一种更加快速的解法：双向 BFS
 * https://leetcode.com/problems/word-ladder-ii/discuss/40477/Super-fast-Java-solution-(two-end-BFS)
 ```
