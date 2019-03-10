# 原题
给定两个字符串 s 和 t，写一个函数判断 t 是否是 s 的一个 “anagram”（颠倒字母顺序构成的词）。 


注意点：

  - 如果输入包含 unicode 字符怎么办？你要怎么调整你的代码来解决这样的问题？

例子：

```
Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false
```

# 解题思路

## 思路一
比较直观的思路是，统计两个字符串中不同字符出现的次数，只有当两者出现的字符相同且出现的次数相同，那么它们是“anagram”。
另外，两个长度不同的字符串一定不满足要求，可以辅助判断。 
判断字符出现次数是否相等，可以两个都统计再比较（用到两个数组），也可以一个增一个减的边统计边比较（一个数组即可）。

#### 代码一

```python
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False

        alpha = [0] * 26
        beta = [0] * 26
        for c in s:
            alpha[ord(c) - 97] += 1
        for c in t:
            beta[ord(c) - 97] += 1
        return alpha == beta
```


#### 代码二

```python
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False

        alpha = [0] * 26
        for c in s:
            alpha[ord(c) - 97] += 1
        for c in t:
            alpha[ord(c) - 97] -= 1
            if alpha[ord(c) - 97] < 0:
                return False
        return True
```

## 思路二
上面用数组的方法对于字符串含有 unicode 就难以处理了，所以更通用的方法应该用字典。算法与上面用数组类似。

#### 代码

```python
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False

        alpha = {}
        beta = {}
        for c in s:
            alpha[c] = alpha.get(c, 0) + 1
        for c in t:
            beta[c] = beta.get(c, 0) + 1
        return alpha == beta
```

## 思路三
两个字符串若是 “anagram”，则它们只是顺序不一样的相同字符的组合，那么将它们排序后比较是否相等即可。

#### 代码

```python
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        return sorted(s) == sorted(t)
```

说明:
这里其实利用Python的排序方便了很多，但要注意 sorted(s) 返回的实际上是字符数组，
所以上面代码 sorted(s) == sorted(t) 的比较是数组比较而不是字符串比较。 
这个算法对于含有 unicode 的字符串也是有效的。
