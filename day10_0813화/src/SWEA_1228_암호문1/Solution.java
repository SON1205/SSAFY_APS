package SWEA_1228_암호문1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			
			List<Integer> cipher = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				cipher.add(sc.nextInt());
			}
			
			int M = sc.nextInt();
			
			for (int i = 0; i < M; i++) {
				sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				for (int j = 0; j < y; j++) {
					cipher.add(x + j, sc.nextInt());
				}
			}
			
			System.out.print("#" + tc + " ");
			for (Integer num : cipher.subList(0, 10)) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}