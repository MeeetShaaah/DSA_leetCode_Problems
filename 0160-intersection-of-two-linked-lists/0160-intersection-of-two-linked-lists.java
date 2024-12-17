/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Approch - 3, usee To achieve O(N + M) time complexity with O(1) space, we consider that both linked lists will eventually align at the intersection point if they intersect. Given that both lists have the same tail when they intersect, we can adjust their starting points.

// The idea is to use two pointers (pA for list A and pB for list B) that traverse the lists. If one pointer reaches the end of its list, it jumps to the head of the other list. By doing this, both pointers traverse the combined length of the two lists, ensuring they meet at the intersection if it exists.

// In simple terms:

// Start both pointers at the heads of the respective lists.
// If one pointer reaches the end of its list, redirect it to the head of the other list.
// Continue moving both pointers one step at a time.
// If they meet (point to the same node), that's the intersection; if not, they will both reach the end simultaneously.
// This approach ensures efficient time and space complexity by reducing the search to a linear traversal.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}

// Approch - 2, with using  hashing, 

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Set<ListNode> set = new HashSet<>();
//         ListNode temp = headA;
//         while(temp != null){
//             set.add(temp);
//             temp = temp.next;
//         }

//         ListNode current = headB;

//         while (current != null){
//             if(set.contains(current)) return current;
//             current = current.next;
//         }
//         return null;
//     }
// }

// Approch - 1, one loop to choose elemnet and other loop is to chomare that element with other list, if both the elements [referance not the values] are same then return true.

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode temp2 = headB;

//         while (temp2 != null){
//             ListNode temp1 = headA;
//             while(temp1 != null){
//                 if (temp1 == temp2){
//                     return temp1;
//                 }
//                 temp1 = temp1.next;
//             }
//             temp2 = temp2.next;
//         }
//         return null;
//     }
// }