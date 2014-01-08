package add_two_numbers;

import datastructure.ListNode;
/*
 * 
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(l1 == null && l2==null)
            return null;
        if(l1==null || l2==null)
            return l1==null?l2:l1;
        
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(l1!=null || l2!=null || carry!=0){
            int sum = carry;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(sum%10);
            carry = sum/10;
            pre = pre.next;
        }
        return dummy.next;
    }
	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(l1 == null || l2 == null)
            return null;
        return helper(l1,l2,0);
    }
    
    public ListNode helper(ListNode l1, ListNode l2,int carry){
        
        if(l1==null && l2==null && carry==0)
            return null;
        int sum = carry;
        if(l1!=null)
            sum+= l1.val;
        if(l2!=null)
            sum+= l2.val;
        ListNode node = new ListNode(sum%10);
        node.next = helper(l1!=null?l1.next:null, l2!=null?l2.next:null, sum/10);
        return node;
    }
}	
