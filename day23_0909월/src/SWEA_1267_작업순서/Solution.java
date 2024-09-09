package SWEA_1267_작업순서;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			List<List<Integer>> adjList = new ArrayList<>();
			
			for (int i = 0; i < V + 1; i++) {
				adjList.add(new ArrayList<>());
			}
			
			int[] degree = new int[V + 1];
			
			for (int i = 0; i < E; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				
				adjList.get(u).add(v);
				degree[v]++;
			}
			
			Deque<Integer> queue = new ArrayDeque<>();
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i < degree.length; i++) {
				if (degree[i] == 0) {
					queue.offer(i);
					sb.append(i).append(" ");
				}
			}
			
			while (!queue.isEmpty()) {
				int tmp = queue.poll();
				
				for (int i = 0; i < adjList.get(tmp).size(); i++) {
					List<Integer> tmpList = adjList.get(tmp);
					if (degree[tmpList.get(i)] != 0) {
						degree[tmpList.get(i)]--;
						
						if (degree[tmpList.get(i)] == 0) {
							queue.offer(tmpList.get(i));
							sb.append(tmpList.get(i)).append(" ");
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + sb);
		}
	}
}