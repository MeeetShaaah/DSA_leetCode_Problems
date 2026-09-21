/* structure for link list node
class Node {
    Node next;
    int data;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node deleteK(Node head, int k) {
        // Your code here
        if(head == null || head.next == null){
            return head;
        }
        
        Node current = head;
        Node prev = null;
        
        int count = 1;
        
        while(current != null){
            if(count == k){
                if(prev == null){
                    head = current.next;
                }else{
                    prev.next = current.next;
                }
                
                current = current.next;
                count = 1;
            }else{
                prev = current;
                current = current.next;
                count++;
            }
        }
        return head;
    }
}