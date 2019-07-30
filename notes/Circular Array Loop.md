# 原题
有一个首尾相接的环形数组，问从任何一个位置i开始走，每次走的步长是nums[i]，
而且每次走的时候要么从左向后走，要么走后向前走，总之只沿着一个方向走，能不能形成一个环。要求环的大小 > 1.

注意点：

  - -1000 ≤ nums[i] ≤ 1000
  - nums[i] ≠ 0
  - 1 ≤ nums.length ≤ 5000


例子：

```
Example 1:

Input: [2,-1,1,2,2]
Output: true
Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.

Example 2:

Input: [-1,2]
Output: false
Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.

Example 3:

Input: [-2,1,-1,-2,-2]
Output: false
Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
```

# 解题思路
### 快慢指针
读题的时候应该意识到和链表有环非常的像，所以可以使用快慢指针，一个走两步，一个走一步，如果相遇说明有环。

这个题难点在于只能沿着一个方向走，所以在每次循环的过程中，必须保证所经历过的所有数字都是同号的，那么在快指针经历过的每个位置都要判断一下和出发点的数字是不是相同的符号，也就是while循环的判断部分。

如果快慢指针相遇的时候，还要判断环的大小不是1，所以，如果相遇点的位置如果再走一步是自己那么也是不行的。如果环的大小不是1，就可以返回True了。

每次移动的时候，慢指针走一步，快指针向后走两步。




