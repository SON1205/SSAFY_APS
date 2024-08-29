package SWEA_1873_상호의배틀필드;

import java.util.Scanner;

public class Solution {
	static char direction;
	static int startR;
	static int startC;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] map = new char[H][];
			
			//scan input
			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
				
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>') {
						direction = map[i][j];
						startR = i;
						startC = j;
						map[i][j] = '.';
					}
				}
			}
			
			//logic
			int N = sc.nextInt();
			
			order(map, sc.next(), startR, startC, 0, N);
			
			//print output
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.print(sb.toString());
		}
	}
	
	static void order(char[][] map, String input, int r, int c, int cnt, int N) {
		if (cnt == N) {
			map[r][c] = direction;
			return;
		}
		
		switch (input.charAt(cnt)) {
		case 'U':
			direction = '^';
			
			if (r - 1 >= 0 && map[r - 1][c] == '.') {
				r--;
			}			
			break;
		case 'D':
			direction = 'v';
			
			if (r + 1 < map.length && map[r + 1][c] == '.') {
				r++;
			}
			break;
		case 'L':
			direction = '<';
			
			if (c - 1 >= 0 && map[r][c - 1] == '.') {
				c--;
			}
			break;
		case 'R':
			direction = '>';
			
			if (c + 1 < map[0].length && map[r][c + 1] == '.') {
				c++;
			}
			break;
		case 'S':
			switch (direction) {
			case '^':
				int idxU = 1;
				while (r - idxU >= 0 && map[r - idxU][c] != '#') {
					if (map[r - idxU][c] == '*') {
						map[r - idxU][c] = '.';
						break;
					} else {
						idxU++;
					}
				}
				break;
			case 'v':
				int idxD = 1;
				while (r + idxD < map.length && map[r + idxD][c] != '#') {
					if (map[r + idxD][c] == '*') {
						map[r + idxD][c] = '.';
						break;
					} else {
						idxD++;
					}
				}
				break;
			case '<':
				int idxL = 1;
				while (c - idxL >= 0 && map[r][c - idxL] != '#') {
					if (map[r][c - idxL] == '*') {
						map[r][c - idxL] = '.';
						break;
					} else {
						idxL++;
					}
				}
				break;
			case '>':
				int idxR = 1;
				while (c + idxR < map[0].length && map[r][c + idxR] != '#') {
					if (map[r][c + idxR] == '*') {
						map[r][c + idxR] = '.';
						break;
					} else {
						idxR++;
					}
				}
			}
		}
		
//		System.out.println(direction + " "  + r + " " + c);
//		
//		StringBuilder sb = new StringBuilder();
//
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				sb.append(map[i][j]);
//			}
//			sb.append("\n");
//		}
//		
//		System.out.println(sb.toString());
		
		order(map, input, r, c, cnt + 1, N);
	}
}