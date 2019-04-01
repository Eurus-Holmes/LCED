from heapq import *
class MedianFinder(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minHeap = []
        self.maxHeap = []
        

    def addNum(self, num):
        """
        :type num: int
        :rtype: None
        """
        heappush(self.maxHeap, -num)
        minTop = self.minHeap[0] if len(self.minHeap) else None
        maxTop = self.maxHeap[0] if len(self.maxHeap) else None
        if minTop < -maxTop or len(self.minHeap) + 1 < len(self.maxHeap):
            heappush(self.minHeap, -heappop(self.maxHeap))
        if len(self.maxHeap) < len(self.minHeap):
            heappush(self.maxHeap, -heappop(self.minHeap))
        

    def findMedian(self):
        """
        :rtype: float
        """
        if len(self.minHeap) < len(self.maxHeap):
            return -1.0 * self.maxHeap[0]
        else:
            return (self.minHeap[0] - self.maxHeap[0]) / 2.0
        


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
