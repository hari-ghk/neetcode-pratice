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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode node: lists){
            minHeap.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){
            ListNode top = minHeap.poll();
            curr.next = top;
            curr = top;

            top = top.next;
            if(top != null)
                minHeap.offer(top);
            
        }
        return dummy.next;
    }
}
