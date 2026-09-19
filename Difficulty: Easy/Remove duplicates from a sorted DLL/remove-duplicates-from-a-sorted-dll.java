/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node headRef) {
        // code here
        Node current = headRef;
        
        while(current != null && current.next != null){
            if(current.data != current.next.data){
                current = current.next;
            }else{
                current.next = current.next.next;
            }
        }
        return headRef;
    }
}