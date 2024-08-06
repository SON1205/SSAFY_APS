package SWEA_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();
			
			String input = sc.next();
			
			String postfixInput = toPrefix(input);
			
			System.out.println("#" + i + " " + evalPostfix(postfixInput));
		}
	}
	
	static int evalPostfix(String str) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else {
				int result = 0;
				
				if (c == '+') {;
					result += stack.pop() + stack.pop();
				} else {
					result += stack.pop() * stack.pop();
				}
				
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
		
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('*', 2);
	}
	
	static String toPrefix(String str) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if ('0' <= c && c <= '9') {
				postfix.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix.append(popItem);
					popItem = stack.pop();
				}
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					postfix.append(stack.pop());
				}
				
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		
		return postfix.toString();
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