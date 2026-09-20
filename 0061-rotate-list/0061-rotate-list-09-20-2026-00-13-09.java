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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int n = 0;

        ListNode current = head;

        while(current != null){
            n++;
            current = current.next;
        }

        k = k % n;

        if(k == 0){
            return head;
        }

        head = reverse(head);

        ListNode first = head;
        ListNode tail = head;

        for(int i = 1; i < k; i++){
            tail = tail.next;
        }

        ListNode secondHalf = tail.next;
        tail.next = null;

        first = reverse(first);
        secondHalf = reverse(secondHalf);

        while(tail.next != null){
            tail = tail.next;
        }

        tail.next = secondHalf;

        return first;

    }

    private ListNode reverse(ListNode head){
        ListNode tail = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = tail;
            tail = current;
            current = next;
        }
        return tail;
    }
}