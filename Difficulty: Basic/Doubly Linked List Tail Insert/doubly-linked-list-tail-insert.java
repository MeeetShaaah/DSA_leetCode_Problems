/* Structure of doubly linked list node
class Node {
    int data;
    Node next;
    Node prev;
    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node insertInTail(Node head, int data) {
        // code here
        Node newNode = new Node(data);
        
        if(head == null){
            return newNode;
        }
        
        Node current = head;
        
        while (current.next != null){
            current = current.next;
        }
        
        current.next = newNode;
        newNode.prev = current;
        
        return head;
    }
}