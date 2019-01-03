# 原题
在Excel中，列名的表示形式为A,B,C...AA,AB...，给定一个正整数，将其转换为对应的列名。

注意点：

  - 无

例子:

```
输入: n = 1

输出: 'A'

输入: n = 28

输出: 'AB'
```

# 解题思路
```
A little bit tricky. When we use mod or divide, we change n to n - 1 such that the mapping becomes:

   0 -> A
   1 -> B
   2 -> C
   ...
   25 -> Z
   26 -> AA
   27 -> AB 

相当于进制转换，转换的基数为26。注意一下高低位的问题，后转换出来的字母应该放在前面，还有所有字母都是大写。
```
