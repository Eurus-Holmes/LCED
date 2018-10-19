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
        
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        
        ListNode ptr0 = fakehead;
        ListNode ptr1 = fakehead.next;
        ListNode ptr2 = fakehead.next.next;
        
        boolean flag = false;
        while(ptr2!=null){
            if(ptr1.val == ptr2.val){
                flag = true;
                ptr2 = ptr2.next;
                if(ptr2 == null)
                    ptr0.next = null;
            }else{
                if(flag){
                    ptr0.next = ptr2;
                    flag = false;
                }else{
                    ptr0 = ptr1;
                }
                ptr1 = ptr2;
                ptr2 = ptr2.next;
            }
        }
        return fakehead.next;
    }
}
