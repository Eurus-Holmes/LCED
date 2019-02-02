# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


# 1. Iteratively

# class Solution(object):
#     def reverseList(self, head):
#         """
#         :type head: ListNode
#         :rtype: ListNode
#         """
#         new_head = None
#         while head:
#             p = head
#             head = head.next
#             p.next = new_head
#             new_head = p            
#         return new_head


# 2. Recursively

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
        
