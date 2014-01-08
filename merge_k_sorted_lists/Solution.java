package merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import datastructure.ListNode;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(lists==null || lists.size()==0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        int k = lists.size();
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                int val1 = node1.val;
                int val2 = node2.val;
                if(val1<val2)
                    return -1;
                else if(val1>val2)
                    return 1;
                else 
                    return 0;
            }
        
        });
        
        for(ListNode node : lists){
            if(node!=null)
                minHeap.add(node);
        }
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            pre.next = node;
            pre = pre.next;
            if(node.next!=null)
                minHeap.add(node.next);
        }
        return dummy.next;
    }
}
