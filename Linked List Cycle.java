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

//   Approach 1: Hash Table
/*  
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
*/


//    Approach 2: Two Pointers
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode Faster = head;
        ListNode Slower = head;
        while(Faster.next!=null && Faster.next.next!=null){
            Slower = Slower.next;
            Faster = Faster.next.next;
            if(Faster == Slower){
                return true;
            }
        }
        return false;
        
    }
}
