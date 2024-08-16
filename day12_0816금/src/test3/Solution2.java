package test3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//삼성시의 버스 노선
public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			Map<Integer, Integer> busstop = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				for (int j = start; j <= end; j++) {
					busstop.put(j, busstop.getOrDefault(j, 0) + 1);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			int P = sc.nextInt();
			
			for (int i = 0; i < P; i++) {
				sb.append(busstop.getOrDefault(sc.nextInt(), 0) + " ");
			}
			
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}
