package test3;

import java.util.Scanner;

//스위치
public class Solution3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		boolean[] switches = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			if (sc.nextInt() == 1) {
				switches[i] = true;
			} else {
				switches[i] = false;
			}
		}
		
		int chance = sc.nextInt();
		
		while (chance > 0) {
			if (sc.nextInt() == 1) {
				int mod = sc.nextInt();
				for (int i = 0; i < N; i++) {
					if ((i + 1) % mod == 0) {
						switches[i] = !switches[i];
					}
				}
			} else {
				int t = 1;
				int center = sc.nextInt() - 1;
				int before = center - t;
				int after = center + t;
				
				switches[center] = !switches[center];
				
				while (before >= 0 && after < N && switches[before] == switches[after]) {
					switches[before] = !switches[before];
					switches[after] = !switches[after];
					before -= t;
					after += t;
				}
			}
			
			
			chance--;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			if (switches[i]) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			
			if (i % 20 == 19) {
				sb.append("\n");
			} else {
				sb.append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}
