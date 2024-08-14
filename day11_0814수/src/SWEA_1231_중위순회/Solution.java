package SWEA_1231_중위순회;

import java.util.Scanner;

public class Solution {
	
	static String[] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			
			sc.nextLine();
			
			tree = new String[N + 1];
			
			for (int i = 1; i < N + 1; i++) {
				tree[i] = sc.nextLine().split(" ")[1];
			}
			
			System.out.print("#" + tc + " ");
			inorder(1);
			
			System.out.println();
		}
	}
	
	public static void inorder(int root) {
		if (root >= tree.length || tree[root] == null) {
			return;
		}
			
		inorder(root * 2);
		System.out.print(tree[root]);
		inorder(root * 2 + 1);
	}


}