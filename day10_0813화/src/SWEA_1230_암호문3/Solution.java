package SWEA_1230_암호문3;

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
				String instruction = sc.next();
				
				switch (instruction) {
				case "I":
					int ix = sc.nextInt();
					int iy = sc.nextInt();
					
					for (int j = ix; j < ix + iy; j++) {
						cipher.add(j, sc.nextInt());
					}
					
					break;
				case "D":
					int dx = sc.nextInt();
					int dy = sc.nextInt();
					
					for (int j = 0; j < dy; j++) {
						cipher.remove(dx);
					}
					
					break;
				default:
					int ay = sc.nextInt();
					
					for (int j = 0; j < ay; j++) {
						cipher.add(cipher.size(), sc.nextInt());
					}
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