/*Structure of the doubly linked list Node
class Node {
	public int data;
	public Node next;
	public Node prev;
	
	public Node(int x) {
		data = x;
		next = null;
		prev = null;
	}
}; */

class Solution {
	public Node deleteAllOccurOfX(Node head, int x) {
		// code here
		Node current = head;
		
		while (current != null) {
			
			if (current.data == x) {
				if (current == head) {
					head = current.next;
					
					if (head != null) {
						head.prev = null;
					}
					
				} else if (current.next == null) {
					current.prev.next = null;
				} else {
					current.next.prev = current.prev;
					current.prev.next = current.next;
				}
			}
			
			current = current.next;
		}
		
		return head;
	}
}
