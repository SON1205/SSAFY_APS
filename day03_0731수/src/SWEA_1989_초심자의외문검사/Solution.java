package SWEA_1989_초심자의외문검사;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] input = sc.next().split("");
		
			boolean palin = true;
		
			for (int i = 0; i < input.length / 2; i++) {
				if (!input[i].equals(input[input.length - 1 - i])) {
					palin = false;
				}
			}
		 
			if (palin) {
				System.out.println("#" + test_case + " " + 1);
			} else {
				System.out.println("#" + test_case + " " + 0);
			}
		}
	}
}
