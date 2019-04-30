# 原题
给定一个嵌套的整数列表，实现一个迭代器将其展开。

每一个元素或者是一个整数，或者是一个列表 -- 其元素也是一个整数或者其他列表。

注意点：

  - 无

例子：

```
Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].

Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
```

# 解题思路
利用栈（Stack）数据结构对嵌套列表展开，在hasNext方法内将下一个需要访问的整数元素准备好。
