package SWEA_미생물;

import java.util.Scanner;

public class Solution {
	
	static int[][] map;
	static boolean[][] now;
	static int[] direction;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			map = new int[N][N];
			now = new boolean[N][N];
			direction = new int[N];
			
			for (int i = 0; i < K; i++) {
				map[sc.nextInt()][sc.nextInt()] = sc.nextInt();
				direction[i] = sc.nextInt();
			}
			
			
		}
	}
}
