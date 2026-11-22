/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt = 0;
        ListNode res = null;
        int len = findLength(head);
        ListNode prev = null;
        while(cnt + k <= len) {
            ListNode rev = reverse(head, k, prev);
            if(cnt/k == 0) {
                res= rev;
            }
            cnt+=k;
            prev = head;
            head = head.next;
        }
        return res;
    }

    ListNode reverse(ListNode head, int k, ListNode p) {
        var cur = head;
        int cnt = 0;
        ListNode next = null;
        ListNode prev = p;
        while(cnt<k &&cur!=null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            cnt++;
        }
        head.next = next;
        if(p!=null) {
            p.next = prev;
        }
        return prev;
    }
    int findLength(ListNode head) {
        int len = 0;
        while(head!=null){
            head = head.next;
            len++;
        }
        return len;
    }
}