# 原题
给定两个字符串S和T，求T有多少种从属于S的子序列的情况。或者说S可以删除它自己任意个字符，但是不能改变字符的相对位置，那一共有多少种删法可以使S变为T。

注意点：

  - 删除任意个字符包括不删除字符

例子:

```
Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
```

# 解题思路
> *"When you see string problem that is about subsequence or matching, 
dynamic programming method should come to your mind naturally."*

### 动态规划
用一个二维数组dp(i)(j)来记录长度为i的字串在长度为j的母串中出现的次数，这里长度都是从头算起的，
而且遍历时，保持子串长度相同，先递增母串长度，母串最长时再增加一点子串长度重头开始计算母串。

首先我们先要初始化矩阵，当子串长度为0时，所有次数都是1，当母串长度为0时，所有次数都是0.
当母串子串都是0长度时，次数是1（因为都是空，相等）。接着，如果子串的最后一个字母和母串的最后一个字母不同，
说明新加的母串字母没有产生新的可能性，可以沿用该子串在较短母串的出现次数，所以`dp(i)(j) = dp(i)(j-1)`。
如果子串的最后一个字母和母串的最后一个字母相同，说明新加的母串字母带来了新的可能性，
我们不仅算上`dp(i)(j-1)`，也要算上新的可能性。那么如何计算新的可能性呢，
其实就是在既没有最后这个母串字母也没有最后这个子串字母时，子串出现的次数，
我们相当于为所有这些可能性都添加一个新的可能。
所以，这时`dp(i)(j) = dp(i)(j-1) + dp(i-1)(j-1)`。

下图是以rabbbit和rabbit为例的矩阵示意图。
计算元素值时，当末尾字母一样，实际上是左方数字加左上方数字，当不一样时，就是左方的数字。

### 示意图
```
     0    r    a    b    b    b    i    t
0    1    1    1    1    1    1    1    1
r    0    1    1    1    1    1    1    1
a    0    0    1    1    1    1    1    1
b    0    0    0    1    2    3    3    3
b    0    0    0    0    1    3    3    3
i    0    0    0    0    0    0    3    3
t    0    0    0    0    0    0    0    3
```

### 复杂度
时间 O(NM) 空间 O(NM)
