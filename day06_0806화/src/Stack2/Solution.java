package Stack2;

public class Solution {
	
}

class Stack<T> {
	private Object[] store;
	private int capacity = 8; //initial capacity
	private int size;
	
	public Stack() {
		store = new Object[capacity];
	}
	
	public Stack(int capacity) {
		store = new Object[capacity];
		this.capacity = capacity;
	}
	
	public boolean push(T item) {
		if (size == capacity) {
			grow();
		}
		
		store[size++] = item;
		return true;
	}
	
	private void grow() {
		Object[] temp = new Object[capacity * 2];
		System.arraycopy(store, 0, temp, 0, capacity);
		store = temp;
		capacity *= 2;
	}
	
	public T pop() {
		if (isEmpty()) {
			return null;
		}
		
		return (T) store[--size];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		
		return false;
	}
	
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		
		return (T) store[size - 1];
	}
}