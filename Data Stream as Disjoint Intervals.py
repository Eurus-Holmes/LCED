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
