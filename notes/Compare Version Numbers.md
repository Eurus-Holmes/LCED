# 原题

```
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", 
it is the fifth second-level revision of the second first-level revision.
```

注意点：

  - 无
  
# 例子:

```
Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1

Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1

Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
```

# 解题思路
比较版本大小。这道题目可以把输入两个string split一下，注意因为"."是特殊regex，
所以要用"\\."。Split完毕以后比较array每个对应元素的大小就可以了。

Time Complexity - O(n)， Splace Complexity - O(n)。
