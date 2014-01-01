package copy_list_with_random_pointer;

import java.util.HashMap;

import datastructure.RandomListNode;

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head;
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head,newHead);
        RandomListNode newCur = newHead;
        while(cur!=null){
            cur = cur.next;
            if(cur!=null){
                newCur.next = new RandomListNode(cur.label);
                newCur = newCur.next;
                map.put(cur,newCur);
            }
            else{
                newCur.next = null;
            }
        }
        cur = head;
        newCur = newHead;
        while(cur!=null){
            if(cur.random==null){
                newCur.random = null;
            }
            else{
                newCur.random = map.get(cur.random);
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}
