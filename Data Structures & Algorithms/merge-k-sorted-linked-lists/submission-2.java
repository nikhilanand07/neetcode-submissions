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

        for(ListNode list : lists){
            while(list != null){
                pq.add(list.val); 
                list = list.next; 
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
