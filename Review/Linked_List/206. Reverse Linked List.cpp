/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* new_head = NULL;
        while(head){
            ListNode* next = head->next; // backup head->next
            head->next = new_head; // change head->next
            new_head = head; // move new_head
            head = next;
        }
        return new_head;
    }
};
