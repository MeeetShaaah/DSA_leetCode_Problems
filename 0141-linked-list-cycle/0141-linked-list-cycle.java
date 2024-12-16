/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Approch - 2, use two pointer, hare tortoise Algo, 
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }
}

// Approch - 1, use Hashmap, traverse through every elements and update the frequencey, if the frequency is 2 then its cycle.

// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode current = head;       

//         HashMap<ListNode, Integer> map = new HashMap<>();

//         while (current != null){
//             if (map.containsKey(current)){
//                 return true;
//             }

//             map.put(current, 1);

//             current = current.next;
//         }
//         return false;
//     }
// }