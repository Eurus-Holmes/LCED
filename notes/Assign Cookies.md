# 原题
假设你是一位awesome的家长想要给孩子一些饼干。
但是，你只能至多给每个孩子一个饼干。
孩子i的贪婪因子为g_i，意思是他所满意的饼干的最小尺寸；每一个饼干j的尺寸为s_j。
如果s_j >= g_i，我们就可以把饼干j分给孩子i，然后孩子i会很满意。
你的目标是最大化分到饼干的孩子的个数。



注意点：

  - 可以假设贪婪因子都是正数。

  - 不可以为一个孩子分配多个饼干。

例子：

```
Example 1:
Input: [1,2,3], [1,1]

Output: 1

Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.

Example 2:
Input: [1,2], [1,2,3]

Output: 2

Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
```

# 解题思路
### 贪心算法（Greedy Algorithm）

```
首先对贪婪系数g、饼干尺寸s从小到大排序

令指针i指向g的末尾，指针j指向s的末尾

当g和s均≥0时，执行循环：

  若g[i] ≤ s[j] 则令计数器+1，并令j -= 1 （将j号饼干分配给i号孩子，并令j指向下一个更小的饼干）

  令i -= 1 （将i指向下一个贪婪系数更小的孩子）
```
