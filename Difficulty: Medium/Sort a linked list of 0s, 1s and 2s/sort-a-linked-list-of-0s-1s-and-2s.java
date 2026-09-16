/*
class Node {
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class Solution {
	public Node segregate(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node zeroDummy = new Node(-1);
		Node oneDummy = new Node(-1);
		Node twoDummy = new Node(-1);
		
		Node zeroTail = zeroDummy;
		Node oneTail = oneDummy;
		Node twoTail = twoDummy;
		
		Node reader = head;
		
		while (reader != null) {
			
			Node next = reader.next;
			reader.next = null;
			
			if (reader.data == 0) {
				zeroTail.next = reader;
				zeroTail = zeroTail.next;
			}
			else if (reader.data == 1) {
				oneTail.next = reader;
				oneTail = oneTail.next;
			}
			else {
				twoTail.next = reader;
				twoTail = twoTail.next;
			}
			
			reader = next;
		}
		
		// 0 → 1 → 2
		if (oneDummy.next == null) {
			zeroTail.next = twoDummy.next;
		} else {
			zeroTail.next = oneDummy.next;
			oneTail.next = twoDummy.next;
		}
		
		return zeroDummy.next;
	}
}
