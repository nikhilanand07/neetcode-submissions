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
        ListNode slow = head; 
        ListNode fast = head; 

        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }

        ListNode second = reverse(slow.next); 
        ListNode first = head; 
        slow.next = null; 

        while(second != null){
            ListNode t1 = first.next; 
            ListNode t2 = second.next; 

            first.next = second; 
            second.next = t1; 

            first = t1; 
            second = t2;
        }
    }

     private ListNode reverse(ListNode head){
        ListNode prev = null; 
        ListNode curr = head; 

        while(curr != null){
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }

        return prev; 
    }
}
