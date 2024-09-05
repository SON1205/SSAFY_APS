package SWEA_1251_하나로;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		double weight;
		
		public Edge(int x, int y, double weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			List<List<Edge>> edges = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				edges.add(new ArrayList<>());
			}
			
			//vertex
			int[][] vertex = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				vertex[i][0] = sc.nextInt(); 
			}
			
			for (int i = 0; i < N; i++) {
				vertex[i][1] = sc.nextInt(); 
			}
			
			double E = sc.nextDouble();
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					edges.get(j).add(new Edge(j, i, E * (Math.pow(vertex[i][0] - vertex[j][0], 2) + Math.pow(vertex[i][1] - vertex[j][1], 2))));
					edges.get(i).add(new Edge(i, j, E * (Math.pow(vertex[i][0] - vertex[j][0], 2) + Math.pow(vertex[i][1] - vertex[j][1], 2))));
				}
			}
			
			boolean[] visited = new boolean[N];
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			visited[0]= true;
			
			double ans = 0;
			int pick = 1;
			
			pq.addAll(edges.get(0));
			
			while (pick != N) {
				Edge e = pq.poll();
				if (visited[e.y]) {
					continue;
				}
				
				ans += e.weight;
				visited[e.y] = true;
				pick++;
				
				pq.addAll(edges.get(e.y));
			}
			
			System.out.println("#" + tc + " " + Math.round(ans));
		}
	}
}