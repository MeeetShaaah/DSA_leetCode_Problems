/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

// Approch - 2, hare and tortoise method,
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) { // this condition check whether the loop exist ot
                slow = head;

                while (slow != fast) { // after finding the cycle, we gonna again put slow pointer at head and both the pointers will move one at a time, there is a mathematical formula for this ***
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// *** Math behied this logic, 
// Mathematical explanation to find the starting node of the cycle:
// Let `d` be the distance from the head of the list to the start of the cycle, 
// `k` be the distance from the start of the cycle to the meeting point, 
// and `C` be the length of the cycle. 
//
// When the slow and fast pointers meet inside the cycle:
// - The slow pointer has traveled a total distance of `d + k`.
// - The fast pointer has traveled `2(d + k)` because it moves twice as fast.
//
// The fast pointer also completes `m` full laps around the cycle, so:
// 2(d + k) = d + k + m * C  (where `m` is the number of full cycles).
//
// Simplifying gives: d + k = m * C.
// This means the distance from the head to the start of the cycle (`d`) 
// is equal to the distance from the meeting point to the start of the cycle (`C - k`).
//
// To find the starting node of the cycle:
// 1. Reset one pointer to the head of the list while keeping the other at the meeting point.
// 2. Move both pointers one step at a time—they will meet at the start of the cycle.
// This works because both pointers are now exactly `d` steps away from the cycle's start.





// Approch - 1, using hashmap
// public class Solution {
// public ListNode detectCycle(ListNode head) {
// ListNode current = head;
// HashMap<ListNode, Integer> map= new HashMap<>();

// while (current != null){
// if(map.containsKey(current)){
// return current;
// }
// map.put(current, 1);
// current = current.next;
// }
// return null;
// }
// }