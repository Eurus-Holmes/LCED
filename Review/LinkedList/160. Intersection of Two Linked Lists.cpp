/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */


// run in O(nlogn) time and use O(n) memory
// class Solution {
// public:
//     ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
//         std::set<ListNode*> node_set;  // set up the search set
//         while(headA){
//             node_set.insert(headA);  // insert headA into node_set
//             headA = headA->next;  
//         }
        
//         while(headB){
            // when in headB find the first node in the node_set
//             if(node_set.find(headB) != node_set.end()){
//                 return headB;  
//             }
//             headB = headB->next;
//         }
        
//         return NULL;
//     }
// };





// run in O(n) time and use only O(1) memory

// get list length
int get_list_length(ListNode* head){
    int len = 0;
    while(head){
        len++;
        head = head->next;
    }
    return len;
}

// move long list to the same position as short list
ListNode* forward_long_list(int long_len, int short_len, ListNode* head){
    int delta = long_len - short_len;
    while(head && delta){
        head = head->next;
        delta--;
    }
    return head;
}

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int list_A_len = get_list_length(headA);
        int list_B_len = get_list_length(headB);
        
        if(list_A_len > list_B_len){
            headA = forward_long_list(list_A_len, list_B_len, headA);
        }
        else{
            headB = forward_long_list(list_B_len, list_A_len, headB);
        }
        
        while(headA && headB){
            if(headA == headB){
                return headA;
            }
            headA = headA->next;
            headB = headB->next;
        }
        
        return NULL;
    }
};
