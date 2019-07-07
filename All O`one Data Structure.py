class KeyNode(object):
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = self.next = None

class ValueNode(object):
    def __init__(self, value, prev, next):
        self.value = value
        self.prev = prev
        self.next = next
        self.first = None
        
class AllOne(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.keyDict = dict()
        self.valueDict = dict()
        self.head = self.tail = None
        

    def inc(self, key):
        """
        Inserts a new key <Key> with value 1. Or increments an existing key by 1.
        :type key: str
        :rtype: None
        """
        if key in self.keyDict:
            keyNode = self.keyDict[key]
            valueNode = self.valueDict[keyNode.value]
            nextValueNode = valueNode.next
            keyNode.value += 1
            if nextValueNode is None or nextValueNode.value > keyNode.value:
                nextValueNode = self.insertValueNodeAfter(keyNode.value, valueNode)
                if self.tail == valueNode:
                    self.tail = nextValueNode
            self.unlinkKey(keyNode, valueNode)
            self.linkKey(keyNode, nextValueNode)
        else:
            keyNode = self.keyDict[key] = KeyNode(key, 1)
            valueNode = self.valueDict.get(1)
            if valueNode is None:
                valueNode = self.valueDict[1] = ValueNode(1, None, self.head)
                if self.head:
                    self.head.prev = valueNode
                self.head = valueNode
                if self.tail is None:
                    self.tail = valueNode
            self.linkKey(keyNode, valueNode)
        

    def dec(self, key):
        """
        Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
        :type key: str
        :rtype: None
        """
        keyNode = self.keyDict.get(key)
        if keyNode is None: return
        valueNode = self.valueDict[keyNode.value]
        if keyNode.value > 1:
            prevValueNode = valueNode.prev
            keyNode.value -= 1
            if prevValueNode is None or prevValueNode.value < keyNode.value:
                prevValueNode = self.insertValueNodeBefore(keyNode.value, valueNode)
                if self.head == valueNode:
                    self.head = prevValueNode
            self.unlinkKey(keyNode, valueNode)
            self.linkKey(keyNode, prevValueNode)
        else:
            self.unlinkKey(keyNode, valueNode)
            del self.keyDict[key]
        

    def getMaxKey(self):
        """
        Returns one of the keys with maximal value.
        :rtype: str
        """
        return self.tail.first.key if self.tail else ''
        

    def getMinKey(self):
        """
        Returns one of the keys with Minimal value.
        :rtype: str
        """
        return self.head.first.key if self.head else ''
    
    def delValueNode(self, valueNode):
        """
        Delete valueNode.
        :rtype: void
        """
        prev, next = valueNode.prev, valueNode.next
        if prev: prev.next = next
        if next: next.prev = prev
        if self.head == valueNode: self.head = next
        if self.tail == valueNode: self.tail = prev
        del self.valueDict[valueNode.value]

    def insertValueNodeAfter(self, value, node):
        """
        Insert a new ValueNode(value) after node.
        :rtype: ValueNode
        """
        newNode = ValueNode(value, node, node.next)
        self.valueDict[value] = newNode
        if node.next: node.next.prev = newNode
        else: self.tail = newNode
        node.next = newNode
        return newNode

    def insertValueNodeBefore(self, value, node):
        """
        Insert a new ValueNode(value) before node.
        :rtype: ValueNode
        """
        newNode = ValueNode(value, node.prev, node)
        self.valueDict[value] = newNode
        if node.prev: node.prev.next = newNode
        else: self.head = newNode
        node.prev = newNode
        return newNode

    def unlinkKey(self, keyNode, valueNode):
        """
        Unlink keyNode from valueNode
        :rtype: void
        """
        next, prev = keyNode.next, keyNode.prev
        if prev: prev.next = next
        if next: next.prev = prev
        if valueNode.first == keyNode: valueNode.first = next
        if valueNode.first is None: self.delValueNode(valueNode)

    def linkKey(self, keyNode, valueNode):
        """
        Link keyNode to valueNode
        :rtype: void
        """
        firstKeyNode = valueNode.first
        keyNode.prev = None
        keyNode.next = firstKeyNode
        if firstKeyNode: firstKeyNode.prev = keyNode
        valueNode.first = keyNode
        


# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()
