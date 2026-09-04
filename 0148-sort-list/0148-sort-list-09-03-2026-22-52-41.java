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
    public ListNode sortList(ListNode head) {

        if(head == null ||  head.next == null){
            return head;
        }

        ListNode rightHead = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return mergeNode(left, right);
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        return slow;
    }

    public ListNode mergeNode(ListNode head1, ListNode head2){
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;

        while (head1 != null && head2 != null){
            if(head1.val <= head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        tail.next = (head1 != null) ? head1 : head2;

        return dummyHead.next;
    }
}