/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode firsthalf = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondhalf = slow.next;
        slow.next = null;
        secondhalf = reverseOrder(secondhalf);
        
        while(secondhalf!=null){
            ListNode temp1 = firsthalf.next;
            ListNode temp2 = secondhalf.next;
            
            firsthalf.next = secondhalf;
            secondhalf.next = temp1;
            
            firsthalf = temp1;
            secondhalf = temp2;
        }
    }
    
    public static ListNode reverseOrder(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode pre = head;
        ListNode curr = head.next;
        
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        
        head.next = null;
        
        return pre;
    }
}
