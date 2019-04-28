# 原题
小偷又给自己找了一个新的偷盗场所。这片区域只有一个入口，叫做“根”。
除了根以外，每一个房间有且仅有一个父级房间。在踩点之后，聪明的盗贼发现“所有的房间形成了一棵二叉树”。
如果两个有边直接相连的房间在同一晚上都失窃，就会自动联络警察。

判断盗贼在不惊动警察的情况下最多可以偷到的金钱数目。

注意点：

  - 无

例子：

```
Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
```

# 解题思路
### 记忆化搜索（DFS + Memoization）

记当前房间为root，如果偷窃当前房间，则其左右孩子left和right均不能偷窃；而其4个孙子节点（ll，lr，rl，rr）不受影响。

因此最大收益为：

```
maxBenifit = max(rob(left) + rob(right), root.val + rob(ll) + rob(lr) + rob(rl) + rob(rr))
```
使用字典valMap记录每一个访问过的节点，可以避免重复运算。

