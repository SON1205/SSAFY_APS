package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int M = sc.nextInt();
            
           	int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int max = findMax(arr, N, M);
                    
            System.out.println("#" + test_case + " " + max);
		}
	}
	
	static int findMax(int[][] arr, int N, int M) {// index 범위 조심, 시작점
		int max = 0;
		
		for (int i = 0; i < N - M + 1; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                int sum = 0;
                
                //파리 잡기 : 크기 M X M
                for (int p = 0; p < M; p++) {
                    for (int q = 0; q < M; q++) {
                        sum += arr[i + p][j + q];
                    }
                }
                
                if (sum > max) {
                    max = sum;
                }
            }
        }
		
		return max;
	}
}