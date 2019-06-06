# 原题
给定两个字符串s和t，都只包含小写字母。

字符串t由字符串s打乱顺序并且额外在随机位置添加一个字母组成。

寻找t中新增的那个字母。

注意点：

  - 无

例子：

```
Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
```

# 解题思路
分别统计s与t的字母个数，然后比对即可。

若使用Python解题，可以使用collections.Counter。
