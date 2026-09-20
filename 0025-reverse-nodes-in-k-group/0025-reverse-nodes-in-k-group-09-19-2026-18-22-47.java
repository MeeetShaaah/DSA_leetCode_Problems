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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = head;
        ListNode reverseGroupTail = dummy;

        while(current != null){
            ListNode tail = current;

            for(int i = 1; i < k && tail != null; i++){
                tail = tail.next;
            }

            if(tail == null){
                break;
            }

            ListNode nextGroupHead = tail.next;

            ListNode reverseGroupHead = reverse(current, tail);

            reverseGroupTail.next = reverseGroupHead;

            reverseGroupTail = current;

            current = nextGroupHead;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail){
        ListNode temp = tail.next;
        ListNode nextNode = tail.next;
        ListNode current = head;

        while(current != temp){
            ListNode next = current.next;
            current.next = nextNode;
            nextNode = current;
            current = next;
        }
        return tail;
    }
}