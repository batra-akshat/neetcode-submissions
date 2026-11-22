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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // nth from end
        int m = 0;
        ListNode* cur = head;
        while (cur != nullptr)
        {
            /* code */
            cur = cur->next;
            m++;
        }
        int idxToRemove = m - n;
        int cnt = 0;
        cur = head;
        ListNode* prev = nullptr;
        if(idxToRemove == 0) {
            return head->next;
        }
        while(cur!=nullptr) {
            if(cnt == idxToRemove) {
                prev->next = cur->next;
                break;
            }
            prev = cur;
            cur = cur->next;
            cnt++;
        }
        return head;
    }
};
