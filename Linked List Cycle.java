/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while(head!=null){
            if(nodesSeen.contains(head)){
                return true;
            }else{
                nodesSeen.add(head);
            } 
            head = head.next;
        }
         return false;
    }
}
