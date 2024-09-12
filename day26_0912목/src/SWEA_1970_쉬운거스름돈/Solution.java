package SWEA_1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {
	static int[] price = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[] result = new int[price.length];
			
			for (int i = 0; i < price.length; i++) {
				int tmp = N / price[i];
				
				if (tmp > 0) {
					result[i] = tmp;
					N -= tmp * price[i];
				}
				
				if (N == 0) {
					break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");
			for (int i : result) {
				sb.append(i).append(" ");
			}
			
			System.out.println(sb);
		}
	}
}