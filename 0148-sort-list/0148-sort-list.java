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

// Approch - 2, using merge sort, this method is same as the regular merge sort, use some brain. 
// -> find mid, -> divide, -> compare, -> conquer
class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeNodes(left, right);
    }

    public ListNode getMid(ListNode head){

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null) prev.next = null;

        return slow;
    }

    public ListNode mergeNodes(ListNode head1, ListNode head2){
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;

        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        tail.next = (head1 != null) ? head1 : head2;

        return dummyHead.next;
    }
}

// Approch - 1, use brute force method using extra space like Array or something, ->add elements into arrayList and sort it using inbuilt method, again convers that arrayList to LL, not a proper method. 