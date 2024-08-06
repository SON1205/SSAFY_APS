package SWEA_1217_거듭제곱;

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
		
		return N * calculateExpo(N, M - 1);
	}
}