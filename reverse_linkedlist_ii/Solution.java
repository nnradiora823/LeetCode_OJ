package reverse_linkedlist_ii;

import datastructure.ListNode;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(m==n)
            return head;
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode pre = dumy;
        ListNode cur = head;
        ListNode tail = null;
        ListNode start = null;
        for(int i = 1; i<=n; i++){
            if(i==m){
                tail = cur;
                start = pre;
                start.next = cur.next;
                pre = cur;
                cur = cur.next;
            }
            else if(i>m && i<n){
                start.next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = start.next;
            }
            else if(i==n){
                tail.next = cur.next;
                cur.next = pre;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dumy.next;
    }
}
