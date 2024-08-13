package LinkedList;

public class Solution_stack {
	public static void main(String[] args) {
		System.out.println(top);
		push(1);
		System.out.println(top);
		push(2);
		System.out.println(top);
		
		System.out.println(pop());
		System.out.println(top);
		
		System.out.println(pop());
		System.out.println(top);
		
		System.out.println(pop());
		System.out.println(top);
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
	
	static Node top = null;
	
	static void push(int item) {
		if (top == null) {
			top = new Node(item);
			return;
		}
		
		Node newNode = new Node(item);
		newNode.next = top;
		top = newNode;
	}
	
	static Node pop() {
		if (top == null) {
			System.out.println("stack이 비었습니다.");
			return null;
		}
		
		Node result = top;
		
		top = result.next;
		
		return result;
	}

}