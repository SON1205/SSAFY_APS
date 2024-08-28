package SWEA_1227_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			int tc = sc.nextInt();
			
			System.out.println("#" + tc + " " + calculateExpo(sc.nextInt(), sc.nextInt()));
		}
	}
	
	static int calculateExpo(int N, int M) {
		if (M == 1) {
			return N;
		}
		
		if (M % 2 == 0) {
			int tmp = calculateExpo(N, M / 2);
			return tmp * tmp;
		} else {
			int tmp = calculateExpo(N, (M - 1) / 2);
			return tmp * tmp * N;
		}
	}
}