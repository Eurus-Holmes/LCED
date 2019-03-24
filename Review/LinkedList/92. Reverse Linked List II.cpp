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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        // the numbers of nodes need to reverse
        int change_len = n-m+1;   
        // initial pre_head of the nodes start to reverse
        ListNode* pre_head = NULL;
        // default head is the first node of the result
        ListNode* result = head;
        
        // move head to the start of reserve
        while(head && --m){
            pre_head = head;   // record pre_head of the head
            head = head->next;
        }
        
        // firstly modify_list_tail point to head of reserve
        ListNode* modify_list_tail = head;
        ListNode* new_head = NULL;
        
        while(head && change_len){
            ListNode* next = head->next;
            head->next = new_head;
            new_head = head;
            head = next;
            change_len--;  // reverse change_len nodes
        }
        
        // connect modify_list_tail to the head of the after reverse
        modify_list_tail->next = head;
        
        // if pre_head is not NULL, and then not from the first node to reverse, namely m>1, default is work
        if(pre_head){
            pre_head->next = new_head; // connect pre_head to new_head
        }
        else{ // if pre_head is NULL, and then is from the first node to reverse, namely m==1, default is not work, result is new_head
            result = new_head;
        }
        return result;
    }
};
