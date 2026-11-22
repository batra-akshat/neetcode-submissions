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
    void reorderList(ListNode* head) {
        // inplace orderering
        int n = 0;
        ListNode* cur = head;
        while(cur!=nullptr) {
            cur = cur->next;
            n++;
        }

        if(n==1) {
            return;
        }

        int rl = (n+1)/2;
        ListNode* ls;
        cur = head;
        n = 0;
        // cout<<rl<<'\n';
        while(cur!=nullptr) {
            // cout<<"n "<<n<<" {rl-1} "<<rl-1<<" Current value "<<cur->val<<'\n';
            if(n == rl-1) {
                ls = cur->next;
                cur->next = nullptr;
                break;
            }
            cur = cur->next;
            n++;
        }
        ls = reverse(ls);
        // cout<<ls->val<<'\n';
        merge(head, ls);
    }

    ListNode* reverse(ListNode* head) {
        ListNode* cur = head;
        ListNode* prev = nullptr;
        ListNode* next;
        while(cur!=nullptr) {
            next = cur->next;
            cur->next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    void merge(ListNode* a, ListNode* b) {
        ListNode dummy = ListNode();
        ListNode* dptr = &dummy;
        int cnt = 0;
        while(a!=nullptr && b!=nullptr) {
            if(cnt%2 == 0) {
                // add from a
                dptr->next = a;
                a  = a->next;
            } else {
                dptr->next = b;
                b = b->next;
            }
            dptr = dptr->next;
            cnt++;
        }

        while(a!=nullptr) {
            dptr->next = a;
            a  = a->next;
            dptr = dptr->next;
        }

        while(b!=nullptr) {
            dptr->next = b;
            b  = b->next;
            dptr = dptr->next;
        }
    }

};
