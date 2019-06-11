# 原题
已经给出了某些变量的比值，求新的变量的比值。如果这个变量没有出现过，或者不可到达，那么返回-1.

注意点：

  - 无

```
Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
```

# 解题思路
这个题其实是一个带权有向图。

题目中给了顶点和顶点之间的关系，其实就是绘制了这个图。然后要求的新的比值其实就是从一个顶点到达另外一个顶点的路径，并且把这条路径上所有的权重相乘。

注意，如果a/b=3，那么从a到b是3，那么从b到a是1/3.

既然是从一个顶点出发到达另外一个顶点，所以应该是dfs解决的问题。

为了防止在DFS中走已经走过了的路，所以需要使用visited保存每次已经访问过的节点。
