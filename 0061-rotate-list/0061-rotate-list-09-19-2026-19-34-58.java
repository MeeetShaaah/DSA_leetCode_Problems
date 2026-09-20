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

        ListNode temp = first;

        while (temp.next != null){
            temp = temp.next; 
        }

        temp.next = secondHalf;

        return first;

    }

    private ListNode reverse(ListNode head){
        ListNode first = null;
        ListNode current = head;

        while(current != null){
            ListNode temp = current.next;
            current.next = first;
            first = current;
            current = temp;
        }
        return first;
    }
}