package SWEA_4613_러시아국기같은깃발;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String[] flag = new String[N];
			
			int max = 0;
			
			//초기화
			for (int i = 0; i < N; i++) {
				flag[i] = sc.next();
			}
			
			//경우를 따지자
			for (int i = 0; i < N - 2; i++) {//R
				for (int j = i + 1; j < N - 1; j++) {//B
					for (int k = j + 1; k < N; k++) {//W
						int tmp = 0;
						
						int idx = 0;
						while (idx < N) {
							if (idx <= i) {
								for (int p = 0; p < M; p++) {
									if (flag[idx].charAt(p) == 'W') {
										tmp++;
									}
								}
							} else if (idx <= j) {
								for (int p = 0; p < M; p++) {
									if (flag[idx].charAt(p) == 'B') {
										tmp++;
									}
								}
							} else {
								for (int p = 0; p < M; p++) {
									if (flag[idx].charAt(p) == 'R') {
										tmp++;
									}
								}
							}
							
							idx++;
						}
						
						if (tmp > max) {
							max = tmp;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + (N * M - max));
		}
	}
}