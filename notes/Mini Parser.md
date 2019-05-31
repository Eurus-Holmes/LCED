# 原题
给定一个以字符串表示的嵌套整数列表，实现一个反序列化的解析器。

每一个元素或者是一个整数，或者是一个列表 -- 其元素也可能是一个整数，或者又是一个列表。

注意点：

  - 字符串非空
  - 字符串不包含空白字符
  - 字符串只包含数字0-9, [, - ,, ]

例子：

```
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.

Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
```

# 解题思路
### 利用栈（Stack）数据结构

```
遍历字符串s，记当前字符为c

如果c为'-'，则将符号变量negmul置为-1

如果c为0-9，则利用变量sigma存储数字的值

如果c为'['，则新建一个类型为列表的NestedInteger并压栈

如果c为']'或者','：

  若sigma非空，则将sigma * negmul加入栈顶元素；

  将栈顶元素弹出记为top；若此时栈非空，将top加入栈顶元素；否则返回top
```
