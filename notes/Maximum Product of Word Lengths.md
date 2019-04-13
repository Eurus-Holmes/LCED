# 原题
找出两个不包含重复字符的字符串长度乘积最大值。

注意点：

  - 无

例子：

```
Example 1:

Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16 
Explanation: The two words can be "abcw", "xtfn".

Example 2:

Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4 
Explanation: The two words can be "ab", "cd".

Example 3:

Input: ["a","aa","aaa","aaaa"]
Output: 0 
Explanation: No such pair of words.
```

# 解题思路
### set
重点是不包含重复字符，显然可以用set统计每个字符串中出现的字符，然后利用O(n^2)的时间复杂度暴力求解。

```python
class Solution:
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        word_dict = dict()
        for word in words:
            word_dict[word] = set(word)
        max_len = 0
        for i1, w1 in enumerate(words):
            for i2 in range(i1+1, len(words)):
                w2 = words[i2]
                if not (word_dict[w1] & word_dict[w2]):
                    max_len = max(max_len, len(w1) * len(w2))
        return max_len
```

### 位运算
这个是个巧妙的方法。我们知道int有32位，而英文小写字符只有26个，所以，对于一个字符串，把其出现过的字符对应到int上去，
那么这个int就能当做这个字符串的摘要，表示这个这个字符串中都有哪些字符。

我们把每个字符串都形成一个摘要，这样只要两个字符串的摘要相与之后的结果是0，那么说明两个字符串没有公共字符。

类似[布隆过滤器](https://www.cnblogs.com/cpselvis/p/6265825.html)。

```python
class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        res = 0
        d = collections.defaultdict(int)
        N = len(words)
        for i in range(N):
            w = words[i]
            for c in w:
                d[w] |= 1 << (ord(c) - ord('a'))
            for j in range(i):
                if not d[words[j]] & d[words[i]]:
                    res = max(res, len(words[j]) * len(words[i]))
        return res
```
