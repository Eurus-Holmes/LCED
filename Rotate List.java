/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fast = head;
        int length = 0;
        // 计算链表长度
        while(fast != null){
            length++;
            fast = fast.next;
        }
        // 如果不旋转或者原链表为空 则直接返回
        if(head == null || k % length == 0){
            return head;
        }
        fast = head;
        // 让快指针先走k步
        for(int i = 0; i < k % length; i++){
            fast = fast.next;
        } 
        // 找到新头节点的前一个节点
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 将后半部分放到前面来
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
