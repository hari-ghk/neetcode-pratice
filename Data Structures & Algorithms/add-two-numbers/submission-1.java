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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(-1, null);
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode t3 = dummy;
        int carry = 0;
        ListNode sums = null;
        while(t1 != null && t2 != null){
           int sum = t1.val + t2.val + carry;
           if(sum >= 10){
             int temp = sum;
             carry = temp / 10;
             sum = sum % 10;
           }
           else 
            carry = 0;
            
            sums = new ListNode(sum, null);
            t3.next = sums;
            t3 = sums;
            t1 = t1.next;
            t2 = t2.next; 
        }

        while(t1 != null){
            int sum = t1.val + carry;
            if(sum >= 10){
             int temp = sum;
             carry = temp / 10;
             sum = sum % 10;
            }
            else 
             carry = 0;
            sums = new ListNode(sum, null);
            t3.next = sums;
            t3 = sums;
            t1 = t1.next;
        }
        
        while(t2 != null){
            int sum = t2.val + carry;
            if(sum >= 10){
             int temp = sum;
             carry = temp / 10;
             sum = sum % 10;
            }
            else 
             carry = 0;
            sums = new ListNode(sum, null);
            t3.next = sums;
            t3 = sums;
            t2 = t2.next;
        }
        
        if(carry != 0){
            sums = new ListNode(carry, null); 
            t3.next = sums;
        }
            
    
        return dummy.next;
    }
}
