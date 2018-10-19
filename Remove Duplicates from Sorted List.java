/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        
        while(ptr2!=null){
            if(ptr1.val == ptr2.val){
                ptr2 = ptr2.next;
                if(ptr2==null)
                    ptr1.next = null;
            }else{
                ptr1.next = ptr2;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }

        return head;
    }
}
