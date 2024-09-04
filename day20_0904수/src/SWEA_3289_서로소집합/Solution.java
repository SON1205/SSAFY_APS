package SWEA_3289_서로소집합;

import java.util.Scanner;

public class Solution {
	static int[] root;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			root = new int[n + 1];
			
			for (int i = 1; i < root.length; i++) {
				root[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				switch (sc.nextInt()) {
				case 1:
					int rx = findSet(sc.nextInt());
					int ry = findSet(sc.nextInt());
					
					if (rx == ry) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					break;
				default:
					union(sc.nextInt(), sc.nextInt());
				}
			}
			
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
	
	static int findSet(int x) {
		if (root[x] == x) {
			return x;
		} else {
			return root[x] = findSet(root[x]);
		}
	}
	
	static void union(int x, int y) {		
		x = findSet(x);
	    y = findSet(y);

	    if (x <= y) {
	    	root[y] = x;
	    } else {
	    	root[x] = y;
	    }
	}
}