# 原题
找出一个连续的自然数序列中，第N位数字是多少。

注意点：

  - 无

例子：

```
Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
```

# 解题思路
找规律：个位数字有9个，2位数字有9*10=90个，3位数字有9*100=900个......
所以我们先求出n是几位数字，然后判断第n个数字应该落在哪个自然数上，最后再求这个自然数会落在自然数的哪一位上。
