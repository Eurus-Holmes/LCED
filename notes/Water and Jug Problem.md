# 原题
给定两个容量分别为x和y升的罐子。提供无限容量的水。你需要判断用这两个罐子是否可以恰好量出z升的体积。

如果可以量出z升水，你最终需要将这些水装在其中的一个或者两个罐子中。

允许的操作包括：

  - 将任意罐子灌满。
  - 将任意罐子清空。
  - 将任意罐子的水倒入另一个罐子，直到另一个罐子倒满或者自己为空为止。


注意点：

  - 无

例子：

```
Example 1: (From the famous ["Die Hard" example](https://www.youtube.com/watch?v=BVtQNK_ZUJg))

Input: x = 3, y = 5, z = 4
Output: True

Example 2:

Input: x = 2, y = 6, z = 5
Output: False
```

# 解题思路
求最大公约数GCD（Greatest Common Divisor)。

如果x与y互质（最大公约数为1），则容量范围[1, x + y]之内的任意整数体积均可以通过适当的操作得到。

否则，记x与y的最大公约数为gcd，则可以获得的容量z只能为gcd的整数倍，且z <= x + y

简单的证明：

```
假设最终体积z = m * x + n * y（m与n为整数，可以为0或者为负）

令x = p * gcd, y = q * gcd，可知p与q互质。

则z = (m * p + n * q) * gcd

可以证明一定存在m, n，使得m * p + n * q = 1（p与q互质的性质，参见：裴蜀定理）

由此可知z一定是gcd的整数倍
```
