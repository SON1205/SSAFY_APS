package SWEA_1208_flatten;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int cnt = sc.nextInt();
            int[] boxes = new int[100];
            
            for (int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }
            
            boxes = method1(boxes, cnt);
            
            System.out.println("#" + test_case + " " + (boxes[99] - boxes[0]));
		}
	}
    
    static int[] method1(int[] arr, int cnt) {
    	while (cnt > 0) {
    		arr = sort(arr);
            
            while (arr[arr.length - 1] >= arr[arr.length - 2] && arr[0] <= arr[1]) {
                arr[arr.length - 1]--;
                arr[0]++;
                cnt--;
            }
    	}
    	
        return sort(arr);
    }
    
    private static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        
        int[] counting = new int[101];
        for (int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }
        
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--counting[arr[i]]] = arr[i];
        }
        
        return result;
    }
}