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

//  Approch - 2, Iterative, 
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head ;
        ListNode prev = null;

        while (current != null){
            ListNode front = current.next;
            current.next = prev;
            prev = current;
            current = front; 
        }
        return prev;
    }
}

// Approch - 1, in Brute Force approch, use stack, TC - SC - O(N)..