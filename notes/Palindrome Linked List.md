# 原题
Given a singly linked list, determine if it is a palindrome.


注意点：

  - 无

例子：

```
Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true
```

# 解题思路
判断回文主要是前半部分和后半部分的比较，若能将后半部分反转（仍然是单链表），则可以方便的判断回文。 
该思路在实现上有多种方法，效率上也有差异。若能不借助多余的空间实现反转单链表后半部分，则可以实现空间复杂度 O(1) 的要求。

时间 O(n)，空间 O(1)
