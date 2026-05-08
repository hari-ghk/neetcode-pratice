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
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode start = slow.next;
        Stack<ListNode> stack = new Stack<>();
        while(start != null){
            stack.push(start);
            start = start.next;
        }
        
        ListNode temp = head;
        
        while(!stack.isEmpty()){
            ListNode prev = temp.next;
            temp.next = stack.pop();
            temp.next.next = prev;
            temp = prev;
        }
        temp.next = null;
    }
}
