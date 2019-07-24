# 原题
把字符串按照字符出现的次数重新排列。

注意点：

  - 无

例子：

```
Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
```

# 解题思路
### 字典
用python真的超级简单呀使用Counter类就能统计每个字符出现的次数，
使用most_common函数就能按次序排列，
最后字符与其出现的次数相乘就得到了字符串。

下面是使用的一个例子的结果：

```python
count = collections.Counter('abbdfas').most_common()
print count

# 输出
[('a', 2), ('b', 2), ('s', 1), ('d', 1), ('f', 1)]
```
