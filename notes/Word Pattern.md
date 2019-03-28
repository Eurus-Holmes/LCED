# 原题
给定一个模式pattern和一个字符串str，判断str是否满足相同的pattern

注意点：

  - 无

例子：

```
Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
```

# 解题思路
使用字典dict分别记录pattern到word的映射以及word到pattern的映射。
