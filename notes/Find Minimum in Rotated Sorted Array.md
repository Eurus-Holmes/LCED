# 原题

```
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
```

注意点：

  - 无
  
例子:

```
Example 1:

Input: [3,4,5,1,2] 
Output: 1

Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
```

# 解题思路
首先假设一个sorted没有rotated的数组[1,2,3]，假设我们通过一个pivot把这个数组rotate，
那么结果可能为：[2,3,1], [3,1,2], 可以发现：num[low]永远大于（或等于）num[high]。
因为你之前是sorted的数组，你在一个sorted的数组找了一个pivot进行rotate，
那么比如pivot后面的值都大于pivot之前的值。所以依据这个发现，以及二分法查找。
我们可以根据以下判断来解题。num[mid]有两种可能性，如果num[mid] > num[high]，
证明num[mid]在rotated后的那个区间内，这个区间我们刚才已知都大于pivot之前的值，
所以最小值就在low=mid+1那个区间内。
另一种可能，num[mid] <= num[high]，那么我们刚才可以看出来这种可能性说明mid~high以及是排好序的，
那么最小值在high=mid这个区间内（mid可能是最小值）。依据此判断可以找到最小值。
