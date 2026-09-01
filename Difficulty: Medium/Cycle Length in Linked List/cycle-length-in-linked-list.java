/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node fast = head;
        Node slow = head;
        
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                slow = head;
                
                while(slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }
                
                int count = 1;
                
                fast = fast.next;
                
                while(fast != slow){
                    fast = fast.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
}