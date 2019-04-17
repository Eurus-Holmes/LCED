# 原题
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

注意点：

  - 无

例子：

```
Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
```

# 解题思路
> [Reference](https://leetcode.com/problems/wiggle-sort-ii/discuss/77678/3-lines-Python-with-Explanation-Proof)


Roughly speaking I put the smaller half of the numbers on the even indexes and the larger half on the odd indexes.

```python
def wiggleSort(self, nums):
    nums.sort()
    half = len(nums[::2])
    nums[::2], nums[1::2] = nums[:half][::-1], nums[half:][::-1]
```

Alternative, maybe nicer, maybe not:

```python
def wiggleSort(self, nums):
    nums.sort()
    half = len(nums[::2]) - 1
    nums[::2], nums[1::2] = nums[half::-1], nums[:half:-1]
```
    
Explanation / Proof

I put the smaller half of the numbers on the even indexes and the larger half on the odd indexes, 
both from right to left:

```
Example nums = [1,2,...,7]      Example nums = [1,2,...,8] 

Small half:  4 . 3 . 2 . 1      Small half:  4 . 3 . 2 . 1 .
Large half:  . 7 . 6 . 5 .      Large half:  . 8 . 7 . 6 . 5
--------------------------      --------------------------
Together:    4 7 3 6 2 5 1      Together:    4 8 3 7 2 6 1 5
```
