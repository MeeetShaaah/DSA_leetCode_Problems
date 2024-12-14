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

//  Approch - 2, used fast and slow pointer;
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
    return slow;
    }
}

//  Approch - 1, convert LL to array and return half; but this approch is not valid. we can create the array of size 100 because it in Constraints, but what if length of LL is unknown.
// class Solution {
//     public ListNode middleNode(ListNode head) {
//         ListNode[] A = new ListNode[100];
//         int  i = 0;
//         Node current = head;
//         while(current != null){
//             A[i++] = current;
//             current = current.next;
//         }
//      return  A[i/2];
//     }
// }