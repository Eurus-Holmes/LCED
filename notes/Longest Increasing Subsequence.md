# 原题
给一个无序的整数数组，找到最长的升序子序列的长度。

注意点：

  - 无

例子：

Input: [10,9,2,5,3,7,101,18]

Output: 4 

Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

# 解题思路
### 二分法 O(nlogn)

ans用来存储最终的升序子序列

初始时ans[0]=nums[0]，逐个向后比较nums[x]，用二分法，确定nums[x]在ans中的位置：

如果比当前ans的最大值还要大，则加在ans后面

如果开始比某个值小了，则把它放在这个值的位置上

### 动态规划 O(n^2) 

每个数字 x 找到它前面比它小的数字 的个数

状态转移方程为： 

dp[x]=max(dp[x],dp[y]+1)
