/* Structure of Doubly Linked List Node
class Node {
	public int data;
	public Node next;
	public Node prev;
	
	public Node(int val) {
		data = val;
		next = null;
		prev = null;
	}
}; */

class Solution {
	public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
		// code here
		
		Node i = head;
		Node j = head;
		
		while (j.next != null) {
			j = j.next;
		}
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		while (i != j && i.prev != j) {
			int sum = i.data + j.data;
			
			if (sum < target) {
				i = i.next;
			} else if (sum > target) {
				j = j.prev;
			} else {
				list.add(new ArrayList<>(Arrays.asList(i.data, j.data)));
				
				i = i.next;
				j = j.prev;
			}
		}
		return list;
	}
}
