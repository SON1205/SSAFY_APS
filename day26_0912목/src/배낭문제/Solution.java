package 배낭문제;

import java.util.Arrays;

public class Solution {
	static final int LIMITWEIGHT = 10;
	
	public static void main(String[] args) {
		int[] weight = {0, 3, 4, 5, 6};
		int[] value = {0, 50, 40, 10, 30};
		
		int[][] values = new int[weight.length][LIMITWEIGHT + 1];
		
		for (int i = 1; i < weight.length; i++) {
			for (int j = 0; j <= LIMITWEIGHT; j++) {
				if (weight[i] <= j) {
					values[i][j] = Math.max(values[i - 1][j], values[i - 1][j - weight[i]] + value[i]);
				} else {
					values[i][j] = values[i - 1][j];
				}
			}
		}
		
		
		for (int[] nums : values) {
			System.out.println(Arrays.toString(nums));
		}
		
		System.out.println(values[weight.length - 1][LIMITWEIGHT]);
	}
}