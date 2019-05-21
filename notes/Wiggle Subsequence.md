# 原题
给定一个数组，让你求最大摆动序列长度。摆动序列定义为序列中任意相邻的三个数中abc，均有 a < b , b >c 或者a>b b<c

注意点：

  - 无

例子：

```
Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.

Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
```

# 解题思路
### 方法一

看到这个就想到和LIS差不多，迅速的DP一下，1A，

设dp[i] 为以i结尾的最大摆动序列长度，sign[i]为i这个数比之前的大还是小（大为1，小-1，初始0），更新条件如下：

```
dp[j] + 1 > dp[i] and (sign[j] > 0 and nums[i] < nums[j] or sign[j] < 0 and nums[i] > nums[j] or sign[j] == 0 and nums[i] != nums[j]):
```

```python
class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums: return 0
        n = len(nums)
        dp, sign = [1] * n, [0] * n
        for i in range(1, n):
            for j in range(i - 1, -1, -1):
                if dp[j] + 1 > dp[i] and (
                                        sign[j] > 0 and nums[i] < nums[j] or
                                        sign[j] < 0 and nums[i] > nums[j] or
                                        sign[j] == 0 and nums[i] != nums[j]):
                    sign[i] = 1 if nums[i] > nums[j] else -1
                    dp[i] = dp[j] + 1
        return max(dp)
```


### 方法二 

虽然dp简单，但其复杂度O(n^2)并不是本题最佳解法。

摇摆序列要求升高，降低，升高。。。

或者降低，升高，降低。。。

那么我们只要找出数组中的“拐点” 即可 举个例子:

4 5 6  3 2 1这几个数中，4为起点，那么5和6中，我们肯定选6啊~因为之后的数要求小于5，小于5的必定也小于6 比如改为4 5 6 5，
之前要是选5就没办法继续往下了。。

总之就是选最小的和选最大的（也就是拐点） 保证不丢最优解。

C++

```c++
class Solution {
public:
	int wiggleMaxLength(vector<int>& nums) {
		if (nums.empty()) return 0;
		int n = nums.size();
		int ans = 1;
		for (int i = 1, j = 0; i < n; j = i,i++) {
			if (nums[j] < nums[i]) {
				ans++;
				while (i + 1 < n && nums[i] <= nums[i + 1]) i++;
			}
			else if (nums[j] > nums[i]) {
				ans++;
				while (i + 1 < n && nums[i] >= nums[i + 1]) i++;
			}
		}
		return ans;
	}
};
```

JAVA
```java
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
		int n = nums.length;
		int ans = 1;
		for (int i = 1, j = 0; i < n; j = i,i++) {
			if (nums[j] < nums[i]) {
				ans++;
				while (i + 1 < n && nums[i] <= nums[i + 1]) i++;
			}
			else if (nums[j] > nums[i]) {
				ans++;
				while (i + 1 < n && nums[i] >= nums[i + 1]) i++;
			}
		}
		return ans;
    }
}
```

PYTHON
```python
class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums: return 0
        n = len(nums)
        ans, i, j, = 1, 1, 0
        while i < n:
            if nums[j] < nums[i]:
                ans += 1
                while i + 1 < n and nums[i + 1] >= nums[i]:
                    i += 1
            elif nums[j] > nums[i]:
                ans += 1
                while i + 1 < n and nums[i + 1] <= nums[i]:
                    i += 1
            i, j = i + 1, i
        return ans
```


        
