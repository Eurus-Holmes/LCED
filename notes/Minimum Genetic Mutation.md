# 原题
给出了一个起始基因，一个结束基因，问能不能通过变换，每次变化当前基因的一位，
并且变化后的这个基因在基因库中的为有效基因，最后变换成为end。如果不可以的话，返回-1.

注意点：

  - 无

例子：

```
Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1
 

Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2
 

Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3
```

# 解题思路
很显然这个问题是BFS的问题，同样是走迷宫问题的4个方向，
代码总体思路很简单，就是利用队列保存每个遍历的有效的字符串，然后对队列中的每个字符串再次遍历，保存每次遍历的长度即可。
每个元素进队列的时候，保存了到达这个元素需要的步数，这样能省下遍历和记录当前bfs长度部分代码。

时间复杂度是O(NL)，空间复杂度是O(N).其中N是Bank中的单词个数，L是基因的长度。



