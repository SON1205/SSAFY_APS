package SWEA_1966_숫자를정렬하자;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			int N = sc.nextInt();
			
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				queue.add(sc.nextInt());
			}
			
//			int[] input = new int[N];
//			
//			for (int i = 0; i < N; i++) {
//				input[i] = sc.nextInt();
//			}
//			
//			sort(input);
//			
			StringBuilder sb = new StringBuilder();
//			
//			for (int i : input) {
//				sb.append(i + " ");
//			}
			

//			
			while (!queue.isEmpty()) {
				sb.append(queue.poll() + " ");
			}
//			
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
	
	static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int idx = i;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
}