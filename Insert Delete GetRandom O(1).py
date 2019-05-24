class RandomizedSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dataMap = {}
        self.dataList = []
        

    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.dataMap:
            return False
        self.dataMap[val] = len(self.dataList)
        self.dataList.append(val)
        return True
        

    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.dataMap:
            return False
        idx = self.dataMap[val]
        tail = self.dataList.pop()
        if idx < len(self.dataList):
            self.dataList[idx] = tail
            self.dataMap[tail] = idx
        del self.dataMap[val]
        return True
        

    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """
        return random.choice(self.dataList)
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
