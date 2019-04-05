# 原题
移除最小数量的无效括号，使得输入字符串有效。返回所有可能的结果。

注意点：

  - 输入字符串除了左右小括号外，还可能包含字母。

例子：

```
Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:

Input: ")("
Output: [""]
```

# 解题思路
### 解法I：深度优先搜索（DFS）+剪枝（Pruning）

利用评价函数计算字符串中未匹配括号的个数

尝试从输入字符串中移除括号，若得到的新字符串的失配括号比原字符串少，则继续搜索；

否则剪枝。

```python
class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def dfs(s):
            mi = calc(s)
            if mi == 0:
                return [s]
            ans = []
            for x in range(len(s)):
                if s[x] in ('(', ')'):
                    ns = s[:x] + s[x+1:]
                    if ns not in visited and calc(ns) < mi:
                        visited.add(ns)
                        ans.extend(dfs(ns))
            return ans    
        def calc(s):
            a = b = 0
            for c in s:
                a += {'(' : 1, ')' : -1}.get(c, 0)
                b += a < 0
                a = max(a, 0)
            return a + b

        visited = set([s])    
        return dfs(s)
```

```
注释：

上述代码中的calc函数统计字符串s中包含的失配括号数目。

其中，变量a统计失配的左括号数目，变量b统计失配的右括号数目。
```

### 解法II：广度优先搜索（BFS）

通过从输入字符串中移除每一个括号，生成新的字符串加入队列。

如果从队列中取出的字符串是有效的，则加入结果列表。

一旦发现有效的字符串，则不再向队列中补充新的可能字符串。

根据BFS的性质，当首次从队列中发现有效字符串时，其去掉的括号数一定是最小的。

而此时，队列中存在的元素与队头元素去掉的括号数的差值 ≤ 1

并且，只有与队头元素去掉括号数目相同的元素才有可能是候选答案（根据括号匹配的性质可知）。

```python
class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def isValid(s):
            a = 0
            for c in s:
                a += {'(' : 1, ')' : -1}.get(c, 0)
                if a < 0:
                    return False
            return a == 0

        visited = set([s])
        ans = []
        queue = collections.deque([s])
        done = False
        while queue:
            t = queue.popleft()
            if isValid(t):
                done = True
                ans.append(t)
            if done:
                continue
            for x in range(len(t)):
                if t[x] not in ('(', ')'):
                    continue
                ns = t[:x] + t[x + 1:]
                if ns not in visited:
                    visited.add(ns)
                    queue.append(ns)

        return ans
```

#### BFS也可应用解法I中的剪枝策略：

```python
class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def calc(s):
            a = b = 0
            for c in s:
                a += {'(' : 1, ')' : -1}.get(c, 0)
                b += a < 0
                a = max(a, 0)
            return a + b

        visited = set([s])
        ans = []
        queue = collections.deque([s])
        done = False
        while queue:
            t = queue.popleft()
            mi = calc(t)
            if mi == 0:
                done = True
                ans.append(t)
            if done:
                continue
            for x in range(len(t)):
                if t[x] not in ('(', ')'):
                    continue
                ns = t[:x] + t[x+1:]
                if ns not in visited and calc(ns) < mi:
                    visited.add(ns)
                    queue.append(ns)

        return ans
```
