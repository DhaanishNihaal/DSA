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
import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head:lists)
        {
            if(head!=null)
                pq.add(head);
        }

        while(!pq.isEmpty())
        {
            ListNode temp = pq.poll();
            dummy.next = temp;
            dummy = temp;
            if(temp.next!=null)
                pq.add(temp.next);

        }
        return ans.next;
        
    }
}