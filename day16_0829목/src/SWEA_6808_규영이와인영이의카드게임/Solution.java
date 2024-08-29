package SWEA_6808_규영이와인영이의카드게임;

import java.util.Scanner;

public class Solution {
	static int[] output = new int[9];
	static int W, L;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int[] gyu = new int[9];
			
			boolean[] isValid = new boolean[19];
			
			for (int i = 0; i < 9; i++) {
				gyu[i] = sc.nextInt();
				isValid[gyu[i]] = true;
			}
			
			int idx = 0;
			for (int i = 1; i < isValid.length; i++) {
				if (!isValid[i]) {
					output[idx++] = i;
				}
			}
			
			W = 0;
			L = 0;
			
			simulGame(gyu, 0);
			
			System.out.println("#" + tc + " " + W + " " + L);
		}
	}
	
	
	static void simulGame(int[] gyu, int depth) {
		if (depth == 9) {
			int GYU = 0;
			int IN = 0;
			
			for (int i = 0; i < output.length; i++) {				
				int tmp = gyu[i] + output[i];
				
				if (gyu[i] > output[i]) {
					GYU += tmp;
					continue;
				}
				
				if (gyu[i] < output[i]) {
					IN += tmp;
				}
			}
			
			if (GYU > IN) {
				W++;
			}
			
			if (IN > GYU) {
				L++;
			}
			
			return;
		}
		
		for (int i = depth; i < 9; i++) {
			swap(depth, i);
			simulGame(gyu, depth + 1);
			swap(depth, i);
		}
	}
	
	static void swap(int depth, int i) {
		int tmp = output[depth];
		output[depth] = output[i];
		output[i] = tmp;
	}
}