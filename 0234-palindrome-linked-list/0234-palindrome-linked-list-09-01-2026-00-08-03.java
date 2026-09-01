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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }

        // 1 2 3 4 4 3 2 1
        ListNode newHead = null;
        ListNode current = slow;

        while (current != null){
            ListNode temp = current.next;
            current.next = newHead;

            newHead = current;
            
            current = temp;
        }

        ListNode left = head;
        ListNode right = newHead;

        while (right != null){
            if(left.val != right.val){
                return false;
            }

            left = left.next;
            right = right.next;
        }
        return true;
    }
}