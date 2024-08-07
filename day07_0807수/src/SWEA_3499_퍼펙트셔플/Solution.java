package SWEA_3499_퍼펙트셔플;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			
			Queue<String> deck1 = new Queue<>();
			Queue<String> deck2 = new Queue<>();
			
			for (int j = 0; j < N; j++) {
				if (j < (N + 1) / 2) {
					deck1.offer(sc.next());
				} else {
					deck2.offer(sc.next());
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int k = 0; k <= N/ 2; k++) {
				if (!deck1.isEmpty())
					sb.append(deck1.poll() + " ");
				if (!deck2.isEmpty())
					sb.append(deck2.poll() + " ");
			}
			
			System.out.println("#" + i + " " + sb.toString());
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