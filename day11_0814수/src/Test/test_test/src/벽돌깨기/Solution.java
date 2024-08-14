package 벽돌깨기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			int H = sc.nextInt();
			
			output = new int[N];
			
			
			
			List<List<Boolean>> exist = new ArrayList<>();
			
			map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			visited = new boolean[H][W];
			
			for (int i = 0; i < W; i++) {
				exist.add(new ArrayList<>());
				for (int j = 0; j < H; j++) {
					if (map[H - 1 - j][i] != 0)
						exist.get(i).add(true);
				}
			}
			
			
		}
	}
	
	static int N;
	static int W;
	static int[] output;
	
	static int[] deltaX = {0, 0, -1, 1};
	static int[] deltaY = {1, -1, 0, 0};
	
	static int[][] map;
	static boolean[][] visited;
	
	static void chooseBox(int depth) {
		if (depth == N) {
			//logic
			
			
			return;
		}
		
		for (int i = 0; i < W; i++) {
			output[depth] = i;
			chooseBox(depth + 1);			
		}
	}
}
