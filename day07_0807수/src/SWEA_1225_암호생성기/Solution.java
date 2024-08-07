package SWEA_1225_암호생성기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int T = 1; T <= 10; T++) {
			sc.nextInt();
			
			Queue<Integer> queue = new Queue<>();
			
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			
			int tmp = 1;
			while (tmp > 0) {
				for (int j = 1; j <= 5; j++) {
					tmp = queue.poll() - j;
					
					if (tmp < 0) {
						tmp = 0;
					}
					
					queue.offer(tmp);
					if (tmp == 0) {
						break;
					}
				}
			}
			
			System.out.print("#" + T + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
		
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
}