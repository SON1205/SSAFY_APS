package SWEA_8931_제로;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int i = 0; i < TC; i++) {
			int K = sc.nextInt();
			
			Stack<Integer> stack = new Stack<>();
			
			int sum = 0;
			
			for (int j = 0; j < K; j++) {
				int price = sc.nextInt();
				
				if (price != 0) {
					stack.push(price);
					sum += price;
				} else {
					sum -= stack.pop();
				}
			}
			
			System.out.println("#" + (i + 1) + " " + sum);
		}
	}
	
	static class Stack<T> {
		List<T> input = new ArrayList<>();
		
		public boolean push(T item) {
			return input.add(item);
		}
		
		public T pop() {
			if (isEmpty()) {
				return null;
			}
			
			return input.remove(input.size() - 1);
		}
		
		public T peek() {
			return input.get(input.size() - 1);
		}
		
		public boolean isEmpty() {
			if (input.size() == 0) {
				return true;
			}
			
			return false;
		}
	}
}