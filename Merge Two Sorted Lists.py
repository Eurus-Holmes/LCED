# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        temp = ListNode(-1)
        head = temp
        while l1 and l2:
            if l1.val > l2.val:
                temp.next = l2
                l2 = l2.next
            else:
                temp.next = l1
                l1 = l1.next
            temp = temp.next
        if l1:
            temp.next = l1
        else:
            temp.next = l2
        return head.next
        
