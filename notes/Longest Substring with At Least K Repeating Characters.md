# 原题
题目要求 满足串中每个字符出现次数都不少于k次的最长子串。

注意点：

  - 无

例子：

```
Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.

Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
```

# 解题思路
首先出现小于k次的字符一定不会出现在要求的子串中，因此统计字符串中每个字符出现的次数，以小于k次的字符为分割点，将字符串分割为几个小片段。
对每个小片段，我们仍需要判断它是否满足每个字符出现次数不小于k，所以对每个小片段递归分割。
终止条件是片段中每个字符次数都不小于k时返回片段长度。
