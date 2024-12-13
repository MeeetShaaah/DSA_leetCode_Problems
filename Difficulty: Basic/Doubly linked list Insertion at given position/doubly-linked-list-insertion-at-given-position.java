//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

class DLinkedList {

    Node newNode(Node head, int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            return head;
        }
        head.next = n;
        n.prev = head;
        head = n;
        return head;
    }

    void printList(Node node) {
        Node temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp.prev != null) {
            temp = temp.prev;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        DLinkedList DLL = new DLinkedList();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            Node temp;
            Node head = null;
            Node root = null;
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(str[i]);
                head = DLL.newNode(head, x);
                if (root == null) root = head;
            }
            head = root;

            String str2[] = read.readLine().trim().split(" ");
            int pos = Integer.parseInt(str2[0]);
            int data = Integer.parseInt(str2[1]);

            Solution g = new Solution();
            head = g.addNode(head, pos, data);

            DLL.printList(head);
            while (head.next != null) {
                temp = head;
                head = head.next;
            }
            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
// public class Node{
//     int data;
//     Node next;
//     Node prev;
    
//     Node(int data){
//         this.data = data;
//         this.next = null;
//         this.prev = null;
//     }
// }

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    // private Node head;
    // private int size = 0;
    
    
    // public int get(int index) {
    //     if (index < 0 || index >= size) return -1; // Return -1 if the index is invalid

    //     Node current = head;
    //     for (int i = 0; i < index; i++) {
    //         current = current.next; // Move to the next node
    //     }
        
    //     return current.data; // Return the data at the given index
    // }
    
    // public void addAtHead(int val) {
    //     Node newNode = new Node(val);
        
    //     if (head != null){
    //         newNode.next = head;
    //         head.prev = newNode;
    //     }
    //     head = newNode;
    //     // size++;
    // }
    
    // public void addAtTail(int val) {
    //     Node newNode = new Node(val);
        
    //     if(head == null) {
    //         head = newNode;
    //         size++;
    //         return;
    //     }
        
    //     Node current = head;
        
    //     while (current.next != null){
    //         current = current.next;
    //     }
        
    //     current.next = newNode;
    //     newNode.prev = current;
    //     // current = newNode; // no need of this line because we already attached the 
        
    //     size++;
        
    // }
    
    // public void addAtIndex(int index, int val) {
    //     if (index < 0 || index > size) return;
        
    //     if (index == 0){
    //         addAtHead(val);
    //         return;
    //     }
        
    //     if (index == size){
    //         addAtTail(val);
    //         size++;
    //         return;
    //     }
        
    //     Node newNode = new Node(val);
    //     Node current = head;
        
    //     for (int i = 0; i < index - 1; i++){
    //         current = current.next;
    //     }
    //     newNode.next = current.next;
    //     current.next.prev = newNode;
    //     current.next = newNode;
    //     newNode.prev = current;
        
    // }
    
    // public void deleteAtIndex(int index) {
    //     if (index < 0 || index >= size || head == null) return;
        
    //     if(index == 0){
    //         head = head.next;
    //         head.prev = null;
    //         size--;
    //         return;
    //     }
    //     Node current = head;
    //     for (int i = 0; i < index; i++){
    //         current = current.next;
    //     }
        
    //     current.next.prev = current.prev;
    //     current.prev.next = current.next;
    //     size--;
    // }
    
       public Node addNode(Node head, int p, int x) {
        // If the position is invalid (negative index), return the head unchanged
        if (p < 0) return head;

        Node newNode = new Node(x);  // Create the new node

        // If we are adding at the head (position 0), handle that case
        if (p == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return head;
        }

        Node current = head;
        
        // Traverse to the pth node (starting from index 0)
        for (int i = 0; current != null && i < p; i++) {
            current = current.next;
        }

        // If the pth node does not exist (out of bounds), return the original head
        if (current == null) return head;

        // Insert the new node after the pth node
        Node nextNode = current.next;  // The node after the pth node
        
        // Link the new node to the pth node
        current.next = newNode;
        newNode.prev = current;

        // If there is a node after the pth node, update its prev pointer to the new node
        if (nextNode != null) {
            newNode.next = nextNode;
            nextNode.prev = newNode;
        } else {
            // If the new node is added at the end, set its next to null (it's already null by default)
            newNode.next = null;
        }

        return head;  // Return the updated head
    }
}