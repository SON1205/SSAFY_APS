package SWEA_1232_사칙연산;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	
	static String[] tree;
	static Deque<String> stack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 1; tc++) {
			int N = sc.nextInt();
			
			sc.nextLine();
			
			tree = new String[N + 1];
			
			for (int i = 1; i < N + 1; i++) {
				tree[i] = sc.nextLine().split(" ")[1];
			}
			
			stack = new ArrayDeque<>();
			
			System.out.print("#" + tc + " ");
			inorder(1);
//			System.out.println(stack.pop());
		}
	}
	
	public static void inorder(int root) {
		if (root >= tree.length || tree[root] == null) {
			return;
		}
		
		inorder(root * 2);
		inorder(root * 2 + 1);
		
		if (tree[root] == "+" || tree[root] == "-" || tree[root] == "/" || tree[root] == "*") {
			int a = Integer.parseInt(stack.pop());
			int b = Integer.parseInt(stack.pop());
			
			switch (tree[root]) {
			case "+":
				stack.push(String.valueOf(a + b));
				break;
			case "-":
				stack.push(String.valueOf(a - b));
				break;
			case "/":
				stack.push(String.valueOf(a / b));
				break;
			case "*":
				stack.push(String.valueOf(a * b));
			}
			
			System.out.println(stack);
		} else {
			stack.push(tree[root]);
		}
		
		System.out.println(Arrays.toString(tree));
	}
}