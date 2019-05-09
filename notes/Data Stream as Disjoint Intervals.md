# 原题
给定一个数据流，输入一组非负整数a1, a2, ..., an, ..., 对截止到当前的不相交区间进行汇总。

注意点：

  - 无

例子：

```
For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
```

# 解题思路

The idea is simple:

when the val-1,val+1 in edges, we insert a period [val-1,val+1]
when val-1 or val +1 in edges, we insert a period [val-1,val], [val,val+1]
else we insert the period [val,val], if it's new , we need append this into list

```python
from bisect import *
class SummaryRanges(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list = []
        

    def addNum(self, val):
        """
        :type val: int
        :rtype: None
        """
        if (val-1) in self.list and (val+1) in self.list:
            low = val-1
            high = val+1
        elif (val-1) in self.list:
            low = val-1
            high = val
        elif (val+1) in self.list:
            low = val
            high = val+1
        else:
            low = high = val
        
        bl = bisect_left(self.list,low)
        br = bisect_right(self.list,high)
        if bl == br and bl%2 == 0:
            self.list.insert(bl,val)
            self.list.insert(bl+1,val)
        
        else:
            self.list[bl:br] = ((bl)%2==0)*[low]+ ((br)%2==0)*[high]
        
        # print low,high, bl,br,self.list
        

    def getIntervals(self):
        """
        :rtype: List[List[int]]
        """
        ans = []
        for i in range(0,len(self.list),2):
            ans += [[self.list[i],self.list[i+1]]]
        return ans


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(val)
# param_2 = obj.getIntervals()
```
