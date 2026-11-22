/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* a, ListNode* b) {
        if(a == nullptr) {                                                 
            return b;
        }
        if(b == nullptr) {
            return a;
        }
        ListNode* l = a;
        ListNode* r = b;
        ListNode* ans;
        if(a->val < b->val) {
            ans = a;
            a = a->next;
        } else{
            ans = b;
            b = b->next;
        }   
        ListNode* prev = ans ;
        ListNode* start = ans;
        while(a != nullptr && b!= nullptr) {
            if(a->val < b->val) {
                ans = a;
                a = a->next;
            } else{
                ans = b;
                b = b->next;
            }
            prev->next = ans;
            prev = ans;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        }
        while(a!=nullptr) {
            ans = a;
            a = a->next;
            prev->next = ans;
            prev=ans;
        }
        while(b!=nullptr) {
            ans = b;
            b = b->next;
            prev->next = ans;
            prev=ans;
        }
        return start;
    }
};
