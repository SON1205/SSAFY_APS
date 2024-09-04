package SWEA_1251_하나로;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static long result;
	
	static int[] root;
	
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
			result = Long.MAX_VALUE;
			
			int N = sc.nextInt();
			
			//vertex
			int[][] vertex = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				vertex[i][0] = sc.nextInt(); 
			}
			
			for (int i = 0; i < N; i++) {
				vertex[i][1] = sc.nextInt(); 
			}
			
			double E = sc.nextDouble();
			
			//edge
			Edge[] edges = new Edge[N * (N - 1) / 2];
			
			int idx = 0;
			for (int i = 0; i < vertex.length - 1; i++) {
				for (int j = i + 1; j < vertex.length; j++) {
					edges[idx++] = new Edge(i, j, E * (Math.pow(vertex[i][0] - vertex[j][0], 2) + Math.pow(vertex[i][1] - vertex[j][1], 2)));
				}
			}
			
			Arrays.sort(edges);
			
			double ans = 0;
			int pick = 0;
			
			//union을 하자
			root = new int[N];
			
			for (int i = 0; i < N; i++) {
				root[i] = i;
			}
			
			for (int i = 0; i < edges.length; i++) {
				int px = findSet(edges[i].x);
				int py = findSet(edges[i].y);

				if (px != py) {
					union(px, py);
					ans += edges[i].weight;
					pick++;
				}

				if (pick == (N - 1))
					break;
			}
			
			if (result > (long) Math.round(ans)) {
				result = (long) Math.round(ans);
			}

			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int findSet(int x) {
		if (root[x] == x) {
			return x;
		} else {
			return root[x] = findSet(root[x]);
		}
	}
	
	static void union(int x, int y) {
		root[y] = x;
	}
}