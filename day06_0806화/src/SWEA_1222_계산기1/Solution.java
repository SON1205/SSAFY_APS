package SWEA_1222_계산기1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();
			
			String input = sc.next();
			
			String postfixInput = toPrefix(input);
			
			System.out.println("#" + i + " " + calculateSum(postfixInput));
		}
		
	}
	
	static int calculateSum(String str) {
		String[] inputs = str.split("");
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < inputs.length; i++) {
			if (!inputs[i].equals("+")) {
				stack.push(Integer.parseInt(inputs[i]));
			} else {
				stack.push(stack.pop() + stack.pop());
			}
		}
		
		return stack.peek();
	}
		
	static String toPrefix(String str) {
		String[] input = str.split("");
		
		Stack<String> stack = new Stack<>();
			
		StringBuilder sb = new StringBuilder();
			
		for (int i = 0; i < input.length; i++) {
			if (!input[i].equals("+")) {
				sb.append(input[i]);
			} else {
				if (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				
				stack.push(input[i]);
			}
			
			if (i == input.length - 1) {
				sb.append(stack.pop());
			}
		}
			
		return sb.toString();
	}
	
	static class Stack<T> {
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
}