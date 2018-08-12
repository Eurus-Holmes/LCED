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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry=0;
        ListNode* listNode=new ListNode(0);
        ListNode* p1=l1,*p2=l2,*p3=listNode;

        while(p1!=NULL|p2!=NULL)
        {
            if(p1!=NULL)
            {
                carry+=p1->val;
                p1=p1->next;
            }
            if(p2!=NULL)
            {
                carry+=p2->val;
                p2=p2->next;
            }
            p3->next=new ListNode(carry%10);
            p3=p3->next;
            carry/=10;
        }
        if(carry==1)
            p3->next=new ListNode(1);
        return listNode->next; 
        
    }
};
