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
        
        ListNode slow = head, fast = head; 

        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }

        ListNode second = reverse(slow.next);
        slow.next = null; 

        ListNode first = head; 

        ListNode temp1 = first; 
        ListNode temp2 = second; 
        while(first != null && second != null){
            temp1 = first.next; 
            first.next = second; 

            temp2 = second.next; 
            second.next = temp1; 

            first = temp1; 
            second = temp2; 
        }


        
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null; 
        ListNode curr = head; 

        while(curr != null){
            head = head.next; 
            curr.next = prev; 
            prev = curr; 
            curr = head; 
        }

        return prev; 
    }
}

/*
2 4 6 10 8

2 10 4 8

*/
