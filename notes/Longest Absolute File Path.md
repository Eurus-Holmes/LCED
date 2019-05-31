# 原题
给定一个字符串，表示文件系统的目录结构。

字符串 "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 表示：

```
dir
    subdir1
    subdir2
        file.ext
```

目录dir包含一个空的子目录subdir1，以及一个包含文件file.ext的目录subdir2。

字符串 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 表示：

```
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
```

目录 dir 包含 2个子目录 subdir1 与 subdir2。 subdir1 包含一个文件 file1.ext 与一个空的二级子目录 subsubdir1。 
subdir2 包含一个二级子目录 subsubdir2 包含一个文件 file2.ext。

我们关心文件系统中的最长（字符个数）绝对路径。例如，上例中的最长绝对路径是"dir/subdir2/subsubdir2/file2.ext"，其长度为32（不包含双引号）。

给定一个以上述格式表示的文件系统字符串，返回其中包含的最长绝对路径的长度。如果文件系统中不包含文件，返回0。

注意点：

  - 文件名中至少包含一个点和一个扩展名。
  - 目录名中不包含点。
  - 时间复杂度要求：O(n)，其中n是字符串的长度。
  - 注意路径 aaaaaaaaaaaaaaaaaaaaa/sth.png 要比 a/aa/aaa/file1.txt 更长。

例子：

如上。

# 解题思路
利用栈（Stack）数据结构。

首先将字符串以'\n'进行分割，得到目录/文件的列表，记为parts

然后统计各目录/文件中'\t'的个数，表示当前目录/文件的深度

遍历parts，若栈顶元素的深度不小于parts的深度，则弹出栈顶元素，重复此过程。

然后将新的深度压入栈中，顺便统计当前目录的总长度。

```python
class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        ans = lengthSum = 0
        stack = [(-1, 0)]
        for p in input.split('\n'):
            depth = p.count('\t')
            name = p.replace('\t', '')
            topDepth, topLength = stack[-1]
            while depth <= topDepth:
                stack.pop()
                lengthSum -= topLength
                topDepth, topLength = stack[-1]
            length = len(name) + (depth > 0)
            lengthSum += length
            stack.append((depth, length))
            if name.count('.'):
                ans = max(ans, lengthSum)
        return ans
```
----
下面的解法十分简洁明了，链接地址：https://discuss.leetcode.com/topic/55097/simple-python-solution

```python
class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        maxlen = 0
        pathlen = {0: 0}
        for line in input.splitlines():
            name = line.lstrip('\t')
            depth = len(line) - len(name)
            if '.' in name:
                maxlen = max(maxlen, pathlen[depth] + len(name))
            else:
                pathlen[depth + 1] = pathlen[depth] + len(name) + 1
        return maxlen
```

