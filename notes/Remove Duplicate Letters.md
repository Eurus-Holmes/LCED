# 原题
给定一个只包含小写字母的字符串，从中移除重复字母使得每个字母只出现一次。你必须确保结果的字典序最小。

注意点：

  - 无

例子：

```
Example 1:

Input: "bcabc"
Output: "abc"

Example 2:

Input: "cbacdcbc"
Output: "acdb"
```

# 解题思路
### 贪心算法（Greedy Algorithm）

时间复杂度 O(k * n)，其中k为字符串中唯一字符的个数，n为字符串的长度

枚举字符串前缀，直到遇到首个唯一字符为止，从前缀中挑选出最小的字符作为首字符。

然后从剩余字符串中移除所有与首字母相同的字母。

重复此过程，直到选出所有唯一字符为止。

```python
class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        ans = ''
        for x in range(len(set(s))):
            top, idx = s[0], 0
            counter = collections.Counter(s)
            for y in range(len(s)):
                if top > s[y]:
                    top, idx = s[y], y
                if counter[s[y]] == 1:
                    break
                counter[s[y]] -= 1
            ans += top
            s = s[idx+1:].replace(top,'')
        return ans
```

### 算法的优化：

使用栈（Stack）数据结构对上述算法进行优化，可以使时间复杂度缩减为O(n)

算法步骤：

首先计算字符串s中每一个字符出现的次数，得到字典counter

遍历字符串s，记当前字符为c，将counter[c] - 1

如果c已经在栈stack中，继续遍历

将字符c与栈顶元素top进行比较，若top > c并且counter[top] > 0则弹栈，重复此过程

将c入栈
算法执行过程中，栈内元素尽可能的保持递增顺序

最后，栈中剩余元素即为所求字符串

```python
class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        counter = collections.Counter(s)
        resultSet = set()
        stack = list()
        for c in s:
            counter[c] -= 1
            if c in resultSet:
                continue
            while stack and stack[-1] > c and counter[stack[-1]]:
                resultSet.remove(stack.pop())
            resultSet.add(c)
            stack.append(c)
        return ''.join(stack)
```

### 递归

```python
def removeDuplicateLetters(self, s):
    for c in sorted(set(s)):
        suffix = s[s.index(c):]
        if set(suffix) == set(s):
            return c + self.removeDuplicateLetters(suffix.replace(c, ''))
    return ''
```
