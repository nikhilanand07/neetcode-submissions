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
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 

        for(ListNode lst : lists){
            while(lst != null){
                pq.add(lst.val);
                lst = lst.next; 
            }
        }

        ListNode head = new ListNode(0); 
        ListNode curr = head; 

        while(!pq.isEmpty()){
            curr.next = new ListNode(pq.poll());
            curr = curr.next; 
        }

        return head.next; 
    }
}
