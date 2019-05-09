# 原题
给定一组以整数对(w, h)表示的信封的宽和高。一个信封可以装下另一个信封，当且仅当前者的宽和高均严格大于后者。

最多可以嵌套多少层信封（有点像俄罗斯套娃）？

注意点：

  - 无

例子：

```
Example:

Input: [[5,4],[6,4],[6,7],[2,3]]

Output: 3 

Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
```

# 解题思路

```
On the first look of this problem, we should be able to come up with sorting the envelopes from small to large. Something like sort(envelopes). Firstly sort by the first dimension (let's say width), then use the second dimension data (height) to solve the LIS problem. However, without carefully modifying your sort criteria, you could be wrong. The reason is: For one doll to cover another , both dimension have to be strictly greater. It means you cannot have something like [[1,2], [1, 3]] in your final doll list.

Here is a tricky data set that better explain the bug in normal patient sort.
A = [[1,4], [2,5], [3,1], [3,2], [3,3]]

The correct answer is to select lst = [[1,4], [2,5]] and answer is 2. But if you go over [[3,1], [3,2], [3,3]] and leverage the binary search to do the overwrite, you could end up with answer 3.

Then you might be conservative and say: Ok, I only pick one for the dolls with same width. Then the previous example ends with answer 2, because after considering [3,1], you will directly ignore [[3,2], [3,3]]. However, this is still wrong.

Consider B = [[1, 2], [2, 1], [2, 3]]. The correct answer should be 2. However, if you just consider the first width=2 doll, which is [2, 1], you will miss the chance to take [2, 3].

So the dilemma is: when you have a group of dolls with the same width, you really don't know which of the following you should do

Pick one with smaller height and overwrite the lst
Pick one with greater height and expand the lst
The right pick is depending on the upcoming dolls. If you do 1, it is possible that you miss the chance to expand the current lst and you get answer that is smaller than right answer. If you do 2, it is possible that the doll you pick has too large height, and you will miss more chances to expand later.

Actually, the correct solution is: when you sort the doll, it should be sorted like envelopes.sort(key = lambda x: (x[0], -x[1])). The first dimension is sorted from small to larget. The second dimension is sorted reversely. Then, you do not need to worry about "Only pick one" for each width. The sorted order would take care of dedupl for you.
```

Here is the solution

```python
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key = lambda x : (x[0], -x[1]))
        
        #print(envelopes)
        
        lst = []
        
        for start, end in envelopes:
            lo, hi = 0, len(lst)
            
            while lo < hi:
                mid = (lo + hi) // 2
                
                if end > lst[mid]:
                    lo = mid + 1
                else:
                    hi = mid
                    
            if lo == len(lst):
                lst.append(end)
            else:
                lst[lo] = end
                
        return len(lst)
 ```
 
