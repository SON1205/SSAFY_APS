package SWEA_7102_준홍이의카드놀이;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] counting = new int[N + M + 1];
			
			Queue<Integer> deck = new Queue<>();
			
			for (int i = 0; i < N; i++) {
				deck.offer(i + 1);
			}
			
			for (int i = 0; i < N; i++) {
				int tmp = deck.poll();
				for (int j = 1; j <= M; j++) {
					counting[tmp + j]++;
				}
			}
			
			int max = 0;
			for (int i = 1; i < 1 + N + M; i++) {
				if (max < counting[i]) {
					max= counting[i];
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i < 1 + N + M; i++) {
				if (max == counting[i]) {
					sb.append(i + " ");
				}
			}
			
			System.out.println("#" + TC + " " + sb.toString());
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