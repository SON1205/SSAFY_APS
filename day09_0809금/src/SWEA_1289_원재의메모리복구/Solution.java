package SWEA_1289_원재의메모리복구;

import java.util.Scanner;

/*
 * 주석 부분으로 실행:20,816 kb / 145 ms
 * 주석 아닌 부분으로 실행: 20,392 kb / 140 ms
 */

public class Solution {
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int cnt = 0;
            
            String input = sc.next();
            
            if (input.charAt(0) == '1') {
            	cnt++;
            }
            
            for (int i = 1; i < input.length(); i++) {
            	if (input.charAt(i) != input.charAt(i - 1)) {
            		cnt++;
            	}
            }
            
//            //String으로 입력받아 숫자 배열로 변환
//            String[] arr = sc.next().split("");
//            int[] bits = new int[arr.length];
//            for (int i = 0; i < arr.length; i++) {
//                bits[i] = Integer.parseInt(arr[i]);
//            }
//            
//            // 초기 상태가 0이므로 1인 경우 cnt 증가
//            if (bits[0] == 1) {
//                cnt++;
//            }
//            
//            // 다음 숫자와 다르면 cnt 증가
//            for (int i = 0; i < bits.length - 1; i++) {
//                if (bits[i + 1] - bits[i] != 0) {
//                    cnt++;
//                }
//            }
             
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}