class RandomizedCollection(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.index = collections.defaultdict(set)
        self.output = []
        

    def insert(self, val):
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        return_val = val not in self.index
        self.index[val].add(len(self.output))
        self.output.append(val)
        return return_val
        

    def remove(self, val):
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.index: return False
        last = self.output.pop()
        self.index[last].remove(len(self.output))
        if val != last:
            index = self.index[val].pop()
            self.index[last].add(index)
            self.output[index] = last
        if not self.index[val]:
            del self.index[val]
        return True
        

    def getRandom(self):
        """
        Get a random element from the collection.
        :rtype: int
        """
        return self.output[random.randint(0, len(self.output) - 1)]
        


# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
