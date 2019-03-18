# 原题
将非负整数转化为其英文单词表示。给定输入确保小于 2 ^ 31 - 1

注意点：

  - 无

例子：

```
Example 1:

Input: 123
Output: "One Hundred Twenty Three"

Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
```

# 解题思路

是否发现了将数字拆分成一组单词的模式？例如，123和123000。

将数字以千为单位分组（3位数）。可以写一个帮助函数，输入一个小于1000的数，然后将其转化为单词。

有许多边际样例。好的测试样例是什么？你的代码可以正确处理诸如0或者1000010的输入吗？（单词中间的0不应该输出）

使用除法和取模运算将数字以千为单位拆分成数组，再分别做单词转化

注意边界条件的处理，不需要考虑添加单词And
