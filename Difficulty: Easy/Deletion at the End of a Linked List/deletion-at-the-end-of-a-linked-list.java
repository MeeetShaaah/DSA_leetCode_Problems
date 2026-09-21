/* Linked List Node Structure
class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = next;
    }
}
*/

class Solution {
    public Node removeLastNode(Node head) {
        // code here
        
        if(head == null || head.next == null){
            return null;
        }
        
        Node current = head;
        
        Node prev = null;
        
        while (current.next != null){
            prev = current;
            current = current.next;
        }
        
        prev.next = null;
        
        return head;
    }
}