# 原题
给定一个只包含大写英文字母的字符串，你可以将其中的任意字母用其他字母替换至多k次。计算替换完成之后可以得到的最大重复字母的长度。

注意点：

  - 字符串长度和k值不会超过10^4

例子：

```
Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
 

Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
```

# 解题思路
### 解法I 滑动窗口（Sliding Window）

定义一段区间内出现次数最多的字符为“优势字符”

维护有效区间[p1, p2]，使得区间内除“优势字符”外的其余字符个数不大于k

时间复杂度O(m * n)，其中m为字母个数, n为字符串长度

```python
class Solution(object):
    def characterReplacement(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        table = collections.Counter()
        res = 0
        p1 = p2 = 0
        while p2 < len(s):
            table[s[p2]] += 1
            p2 += 1
            while p2 - p1 - max(table.values()) > k:
                table[s[p1]] -= 1
                p1 += 1
            res = max(res, p2 - p1)
        return res
```

### 解法II 统计单词连续区间 + 枚举字母 + 枚举区间起止点

时间复杂度O(m * n)，其中m为字母个数, n为区间数

首先统计出字符串内各单词所在的连续区间，记为cdict，例如AABABBA得到的区间为{A : [(0, 1), (3, 3), (6, 6)], B : [(2, 2), (4, 5)]}

然后枚举需要保留的字母

尝试用k值填补区间之间的间隙，并更新最优答案。

```python
class Solution(object):
    def characterReplacement(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        sizes = len(s)
        letters = set(s)

        cdict = collections.defaultdict(list)
        li, lc = 0, (s[0] if s else None)
        for i, c in enumerate(s):
            if c != lc:
                cdict[lc].append( (li, i - 1) )
                li, lc = i, c
        cdict[lc].append( (li, sizes - 1) )

        ans = 0
        for c in letters:
            invs = cdict[c]
            ans = max(ans, max(y - x + 1 + min(k, x + sizes - 1 - y) for x, y in invs))
            sizec = len(invs)
            cnt = k
            sp = 0
            ep = 1
            while sp < sizec and ep < sizec:
                if cnt >= invs[ep][0] - invs[ep - 1][1] - 1:
                    cnt -= invs[ep][0] - invs[ep - 1][1] - 1
                    lenc = invs[ep][1] - invs[sp][0] + 1 + min(cnt, invs[sp][0] + sizes - 1 - invs[ep][1])
                    ans = max(ans, lenc)
                    ep += 1
                else:
                    sp += 1
                    cnt += invs[sp][0] - invs[sp - 1][1] - 1
        return ans
```
