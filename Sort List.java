/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode firstHalf = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalf = slow.next;
        slow.next = null;
        
        ListNode leftList = null;
        ListNode rightList = null;
        if(firstHalf!=secondHalf){
            leftList = sortList(firstHalf);
            rightList = sortList(secondHalf);
        }
        
        return mergeTwoLists(leftList,rightList);
    }
    
    public ListNode mergeTwoLists(ListNode leftList, ListNode rightList){
        if(leftList == null){
            return rightList;
        }
        if(rightList == null){
            return leftList;
        }
        
        ListNode fakeHead = new ListNode(-1);
        ListNode ptr = fakeHead;
        while(rightList!=null && leftList!=null){
            if(rightList.val<leftList.val){
                ptr.next = rightList;
                ptr = ptr.next;
                rightList = rightList.next;
            }
            else{
                ptr.next = leftList;
                ptr = ptr.next;
                leftList = leftList.next;
            }
        }
        
        if(rightList!=null){
            ptr.next = rightList;
        }
        if(leftList!=null){
            ptr.next = leftList;
        }
        
        return fakeHead.next;
    }
}
