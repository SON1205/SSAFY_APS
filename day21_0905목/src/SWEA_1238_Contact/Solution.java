package SWEA_1238_Contact;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int E = sc.nextInt();
			int start = sc.nextInt();
			
			boolean[][] map = new boolean[101][101];
			
			for (int i = 0; i < E / 2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				map[x][y] = true;
			}
			
			boolean[] visited = new boolean[101];
			
			List<Integer> results = new ArrayList<>();
			
			Deque<Integer> queue = new ArrayDeque<>();
			visited[start] = true;
			queue.offer(start);
			
			while (!queue.isEmpty()) {
				int size = queue.size();
				int max = 0;
				
				for (int k = 0; k < size; k++) {
					int tmp = queue.poll();
					
					for (int i = 1; i < 101; i++) {
						if (map[tmp][i] && !visited[i]) {
							visited[i] = true;
							queue.offer(i);
							max = Math.max(max, i);
						}
					}
				}
				
				results.add(max);
			}
			
			System.out.println("#" + tc + " " + results.get(results.size() - 2));
		}
	}
}