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

// Approch - 2, hare and tortoise method,....!!!
class Solution {
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode newHead = reverse(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = reverse(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        while(second != null){
            if (first.val != second.val) return false;
            
            second = second.next;
            first = first.next;
        }
        return true;
    }
}

// Approch - 1, traverse the LL and add every node to the stack 

// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode current = head;
//         Stack<Integer> stack = new Stack<>();

//         while (current != null){
//             stack.push(current.val);
//             current = current.next;
//         }

//         current = head;

//         while (current != null){
//             if (current.val != stack.peek()){
//                 return false;
//             }

//             stack.pop();
//             current = current.next;
//         }
//         return true;
//     }
// }