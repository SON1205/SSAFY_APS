package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            //입력
            int[][] arr = new int[100][100];
            
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            //로직
            int max = findRowAndColMax(arr) > findCrossMax(arr)
            		? findRowAndColMax(arr) : findCrossMax(arr);
            
            //출력
            System.out.println("#" + test_case + " " + max);
		}
	}
	
	static int findRowAndColMax(int[][] arr) {
		int max = 0;
		
		for (int p = 0; p < 2; p++) {
			for (int i = 0; i < 100; i++) {
	             int sum = 0;
	             
	             for (int j = 0; j < 100; j++) {
	            	 if (p % 2 == 0) {
	            		 sum += arr[j][i];//가로 합
	            	 } else {
	            		 sum += arr[i][j];//세로 합
	            	 }
	                 
	             }
	             
	             if (sum > max) {
	                 max = sum;
	             }
	         }
		}
		 
		return max;
	}
	
	static int findCrossMax(int[][] arr) {
		int max = 0;
        
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
        
        return max;
	}
}