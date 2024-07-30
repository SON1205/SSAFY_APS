package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            
            int[][] arr = new int[100][100];
            
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int max = 0;
            
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                //세로 합
                for (int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                }
                
                if (sum > max) {
                    max = sum;
                }
            }
            
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                //가로 합
                for (int j = 0; j < 100; j++) {
                    sum += arr[j][i];
                }
                
                if (sum > max) {
                    max = sum;
                }
            }
            
            for (int i = 0; i < 2; i++) {
                int sum = 0;
                //대각선 합
                if (i == 0) {
                    for (int j = 0; j < 100; j++) {
                    	sum += arr[99 - j][j];
                	}
                } else {
                    for (int j = 0; j < 100; j++) {
                    	sum += arr[j][j];
                	}
                }
                
                if (sum > max) {
                    max = sum;
                }
            }
            
            System.out.println("#" + test_case + " " + max);
		}
	}
}