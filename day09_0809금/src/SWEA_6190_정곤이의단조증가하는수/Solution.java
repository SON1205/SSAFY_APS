package SWEA_6190_정곤이의단조증가하는수;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = 0;
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int tmp = arr[i] * arr[j];
					
					if (!checkAsc(tmp)) {
						continue;
					}
					
					if (tmp > max) {
						max = tmp;
					}
				}
			}
			
			if (max == 0) {
				System.out.println("#" + tc + " " + -1);
			} else {
				System.out.println("#" + tc + " " + max);
			}
		}
	}
	
	static boolean checkAsc(int num) {
		if (num < 10) {
			return false;
		}
		
		while (num > 0) {
			int tmp = num / 10 % 10;
			
			if (tmp > num % 10) {
				return false;
			}
			
			num /= 10;
		}
		
		return true;
	}
}