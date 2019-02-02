# 原题
Reverse a singly linked list.

注意点：

  - 无
  
例子：

Input: 1->2->3->4->5->NULL

Output: 5->4->3->2->1->NULL

# 解题思路
### 思路一
利用栈结构，将链表内容依次压入栈，再从栈依次弹出即可构造逆序。下面用普通数组模拟栈。


```python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        p = head
        newList = []
        while p:
            newList.insert(0, p.val)
            p = p.next

        p = head
        for v in newList:
            p.val = v
            p = p.next
        return head
```

### 思路二
与思路一栈的思想类似，不过是直接在原链表操作，通过迭代将节点重组，前面的节点转移到重组链表的后面。实际上就是头结点倒插操作。


```python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        new_head = None
        while head:
            p = head
            head = head.next
            p.next = new_head
            new_head = p
        return new_head
```

### 思路三
递归，注意终止条件

```python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head

        p = head.next
        n = self.reverseList(p)

        head.next = None
        p.next = head
        return n
```
