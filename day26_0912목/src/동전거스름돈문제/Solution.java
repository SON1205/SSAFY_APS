package 동전거스름돈문제;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		
		int[] coins = new int[money + 1];
		
		coins[1] = 1;
		
		for (int i = 2; i < coins.length; i++) {
			int tmp = coins[i - 1] + 1;
			
			if (i >= 6) {
				coins[i] = Math.min(coins[i - 6] + 1, Math.min(tmp, coins[i - 4] + 1));
			} else if (i >= 4) {
				coins[i] = Math.min(tmp, coins[i - 4] + 1);
			} else {
				coins[i] = tmp;
			}
		}
		
		System.out.println(Arrays.toString(coins));
		
		System.out.println(coins[money]);
	}
}