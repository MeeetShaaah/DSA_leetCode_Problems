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
        ListNode reverseGroupConnect = dummy;

        while(current != null){
            ListNode groupTail = current;

            for(int i = 1; i < k && groupTail != null; i++){
                groupTail = groupTail.next;
            }

            if(groupTail == null){
                break;
            }
            
            ListNode nextGroupHead = groupTail.next;
            
            ListNode newHead = reverseGroup(current, groupTail);

            reverseGroupConnect.next = newHead;

            reverseGroupConnect = current;

            current = nextGroupHead;
        }

        return dummy.next;
    }

    private ListNode reverseGroup(ListNode head, ListNode tail){
        ListNode temp = tail.next;
        ListNode toConnectNode = temp;
        ListNode current = head;

        while(current != temp){
            ListNode next = current.next;
            current.next = toConnectNode;
            toConnectNode = current;
            current = next;
        }
        return tail;
    }
}