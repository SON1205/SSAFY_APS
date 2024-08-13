package LinkedList;

public class Solution_queue {
	public static void main(String[] args) {
		offer(1);
		System.out.println(front);
		offer(2);
		offer(3);
		System.out.println(front);
		
		System.out.println(poll());
		System.out.println(front);
		System.out.println(poll());
		System.out.println(front);
		System.out.println(poll());
		System.out.println(front);
	}
	
	static class Node {
		int item;
		Node next;
		
		Node() {
			
		}
		
		Node(int item) {
			this.item = item;
		}

		@Override
		public String toString() {
			return "Node [item=" + item + "]";
		}
	}
	
	static Node front;
	
	static void offer(int item) {
		if (front == null) {
			front = new Node(item);
			return;
		}
		
		Node newNode = new Node(item);
		
		Node x = findLastNode();
		
		x.next = newNode;
	}
	
	static Node poll() {
		if (front == null) {
			System.out.println("queue가 비었습니다.");
			return null;
		}
		
		Node result = front;
		
		front = result.next;
		
		return result;
	}
	
	private static Node findLastNode() {
		Node x = front;
		while (x.next != null) {
			x = x.next;
		}
		
		return x;
	}
}
