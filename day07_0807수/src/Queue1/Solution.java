package Queue1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		
		queue.offer(1);
		System.out.println(queue);
		queue.offer(1);
		System.out.println(queue);
		queue.offer(1);
		System.out.println(queue);
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
	
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);

	}
	
	static class Queue<T> {
		private List<T> store;

		public Queue() {
			store = new ArrayList<>();
		}
		
		public boolean offer(T item) {
			return store.add(item);
		}
		
		public T poll() {
			if (isEmpty()) {
				return null;
			}
			
			return store.remove(0);
		}
		
		public boolean isEmpty() {
			return store.isEmpty();
		}
		
		public T peek() {
			if (isEmpty()) {
				return null;
			}
			
			return store.get(0);
		}
		
		public int size() {
			return store.size();
		}

		@Override
		public String toString() {
			return "Queue = " + store;
		}
	}
	
	static class ArrQueue<T> {
		private Object[] store;
		private int front = -1;
		private int rear = -1;
		
		public ArrQueue() {
			store = new Object[10];
		}
		
		public ArrQueue(int size) {
			store = new Object[size];
		}
		
		public boolean isEmpty() {
			return front == rear;
		}
		
		public boolean isFull() {
			return rear == store.length - 1;
		}
		
		public boolean enQueue(T item) {
			if (isFull()) {
				return false;
			}
			
			store[++rear] = item;
			return true;
		}
		
		public T deQueue() {
			if (isEmpty()) {
				return null;
			}
			
			return (T) store[++front];
		}
		
		public T Qpeek() {
			if (isEmpty()) {
				return null;
			}
			
			return (T) store[front + 1];
		}
		
		public int size() {
			return rear - front;
		}
	}
}