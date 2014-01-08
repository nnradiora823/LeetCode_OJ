package reverse_nodes_in_k_group;

import datastructure.ListNode;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */

public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head==null || head.next==null || k==0)
            return head;
        ListNode left = head;
        ListNode right = head;
        int count = 1;
        while(count<=k && right!=null){
            right = right.next;
            count++;
        }
        if(count-1!=k && right==null)
            return left;
        ListNode pre = null;
        ListNode cur = left;
        while(cur!=right){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        left.next = reverseKGroup(cur, k);
        return pre;
    }
}
