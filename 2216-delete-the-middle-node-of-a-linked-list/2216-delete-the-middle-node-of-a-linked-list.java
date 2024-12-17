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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        fast = fast.next.next; // The reason is that if both fast and slow pointers move at the same pace, // the slow pointer will stop at the middle node, and removing 'slow.next' would skip the middle node itself. To remove the middle node, we need the slow pointer to stop one node before the middle. To achieve this, we initialize fast = fast.next.next.

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != null){
            slow.next = slow.next.next;
        }
        return head;
    }
}