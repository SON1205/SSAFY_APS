package test3;

import java.util.Arrays;
import java.util.Scanner;

//신입사원 분반 교육
public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int min = sc.nextInt();
			int max = sc.nextInt();
		
			int[] score = new int[N];
			
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
			}
			
			Arrays.sort(score);
			
			int re = 1000;
			
			for (int i = 0; i < N - 2; i++) {
				if (score[i] == score[i + 1]) {
					continue;
				}
				
				for (int j = i + 1; j < N - 1; j++) {
					if (score[j] == score[j + 1]) {
						continue;
					}
					
					int[] result = new int[3];
					
					result[0] = i + 1;
					result[1] = j - i;
					result[2] = N - 1 - j;
					
					boolean isValid = true;
					
					for (int k = 0; k < 3; k++) {
						if (result[k] < min || result[k] > max) {
							isValid = false;
							break;
						}
					}
					
					if (isValid) {
						Arrays.sort(result);
						if (re > result[2] - result[0]) {
							re = result[2] - result[0];
						}
					}
				}
			}
			
			if (re == 1000) {
				re = -1;
			}
			
			
			System.out.println("#" + tc + " " + re);
		}
	}
}
