package SWEA_1213_String;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int x = sc.nextInt();
            String searchValue = sc.next();
            String searchedItem = sc.next();
            
            //�� ã���� �ε��� -1
            int count = 0;
            int index = searchedItem.indexOf(searchValue);
            
            while (index > 0) {
                count++;
                index = searchedItem.indexOf(searchValue, index + 1);
            }
            
            System.out.println("#" + x + " " + count);
		}
	}
}