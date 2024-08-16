package SWEA_2930_힙;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			int cnt = sc.nextInt();
			
			System.out.print("#" + tc + " ");
			
			for (int i = 0; i < cnt; i++) {
				if (sc.nextInt() == 1) {
					pq.add(sc.nextInt());
				} else {
					if (pq.isEmpty()) {
						System.out.print(-1 + " ");
						continue;
					}
					
					System.out.print(pq.remove() + " ");
				}
			}
			
			System.out.println();
		}
	}
}