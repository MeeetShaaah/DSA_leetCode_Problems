/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int a){
        data = a;
        next = null;
    }
    
    Nde(int a, Node next){
        this.a = a
        this.next = next;
    }
}
*/
class Solution {
    public int getCount(Node head) {
        // code here
        Node temp = head.next;
        
        int count = 1;
        
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}