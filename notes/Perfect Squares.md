# 原题
Given a positive integer n, find the least number of perfect square numbers
(for example, 1, 4, 9, 16, ...) which sum to n.

注意点：

  - 无

例子：

```
Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
```

# 解题思路
四平方和定理：(Lagrange's four-square theorem)亦称拉格朗日四平方数和定理。
四平方数和问题是著名的数论问题.由拉格朗日(La-grange, J.-L.)最终解决，从而有上面的定理名字.
该定理断言:每个正整数均可表为四个整数的平方和(其中有些整数可以为零)。

推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=（4^ a） * (8b+7)

### [My First Post](https://leetcode.com/problems/perfect-squares/discuss/259868/Python-beat-99-Solution-using-Number-theory%3A-Lagrange's-four-square-theorem)
