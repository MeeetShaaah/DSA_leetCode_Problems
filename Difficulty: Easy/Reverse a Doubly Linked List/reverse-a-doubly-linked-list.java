/* Structure of Doubly Linked List Node
class Node {
	int data;
	Node next;
	Node prev;
	
	Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
*/
class Solution {
	public Node reverse(Node head) {
		// code here
		Node left = head;
		Node right = head;
		
		while (right.next != null) {
			right = right.next;
		}
		
		while (left != right && left.prev != right) {
			
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			
			left = left.next;
			right = right.prev;
		}
		
		return head;
	}
}
