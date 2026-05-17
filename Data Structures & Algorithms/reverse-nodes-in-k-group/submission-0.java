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

/*
dummy.next = head 

prev = dummy
temp = head
next = temp.next 
temp.next = prev
prev = temp
temp = prev.next

k.next = y // this becomes the 
*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(-1, head);
        ListNode gPrev = dummy;

        while(true){
            ListNode kth = getKth(gPrev, k);
            if(kth == null){
                break;
            }
            ListNode gNext = kth.next;
            ListNode prev = kth.next;
            ListNode curr = gPrev.next;
            while(curr != gNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = gPrev.next;
            gPrev.next = kth;
            gPrev = temp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k){
        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
