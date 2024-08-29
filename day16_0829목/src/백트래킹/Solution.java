package 백트래킹;

import java.util.Scanner;

public class Solution {
	
	static int[] input;
	
	static boolean[] visited;
	
	static int[] output;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		input = new int[N];
		for (int i = 0; i < N; i++)	{
			input[i] = i + 1;
		}
		
		int M = sc.nextInt();
		
		
		output = new int[M];
		visited = new boolean[N];
		
		perm(0, M);
		
	}
	
	static void perm(int cnt, int M) {
		if (cnt == M) {
			for (int i : output) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[cnt] = input[i];
				perm(cnt + 1, M);
				visited[i] = false;
			}
		}
	}
}