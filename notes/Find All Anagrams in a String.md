# 原题
给定一个字符串s与一个非空字符串p，寻找s中所有p的字谜变换的起始下标。

字符串只包含小写英文字母并且s和p的长度均不超过20100。

输出顺序无所谓。

注意点：

  - 无

例子：

```
Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```

# 解题思路
字符统计，单词的字谜变换（anagram）是指与其字母个数相同只是顺序不同的单词。

----
下面的代码将时间复杂度优化至O(n)

字典cp记录要凑成目标字符串p的anagram，各字符分别缺多少个

整数count记录凑成目标字符串p一共还缺多少个字符

参考LeetCode Discuss：https://discuss.leetcode.com/topic/64434/shortest-concise-java-o-n-sliding-window-solution

```python
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        ls, lp = len(s), len(p)
        count = lp
        cp = collections.Counter(p)
        ans = []
        for i in range(ls):
            if cp[s[i]] >=1 :
                count -= 1
            cp[s[i]] -= 1
            if i >= lp:
                if cp[s[i - lp]] >= 0:
                    count += 1
                cp[s[i - lp]] += 1
            if count == 0:
                ans.append(i - lp + 1)
        return ans
```
