# 原题
输入三个字符串s1、s2和s3，判断第三个字符串s3是否由前两个字符串s1和s2交替而成且不改变s1和s2中各个字符原有的相对顺序。

注意点：

  - 无

例子：

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"

输出: True

# 解题思路
引用一句话:

*“When you see string problem that is about subsequence or matching, 
dynamic programming method should come to your mind naturally. ”*

所以这道题还是用DP的思想解决。

大体思路是，s1取一部分s2取一部分，最后是否能匹配s3。

动态规划数组是dp[i][j]，表示：s1取前i位，s2取前j位，是否能组成s3的前i+j位。

初始化是，假设s1为空，那么s2每一位跟s3匹配放入dp[0][j]；假设s2为空，那么s1每一位跟s3匹配放入dp[i][0]。

下面就继续匹配。

那什么时候取True，什么时候取False呢？

False很直观，如果不等就是False了嘛。

那True呢？首先第一个条件，新添加的字符，要等于s3里面对应的位( i + j 位)，第二个条件，之前那个格子也要等于True

举个简单的例子s1 = ab, s2 = c, s3 = bbc ，假设s1已经取了2位，c还没取，此时是False（ab!=bb），
我们取s2的新的一位c，即便和s3中的c相等，但是之前是False，所以这一位也是False

同理，如果s1 = ab, s2 = c, s3=abc ，同样的假设，s1取了2位，c还没取，此时是True（ab==ab），
我们取s2的新的一位c,和s3中的c相等，且之前这一位就是True，此时我们可以放心置True （abc==abc）
