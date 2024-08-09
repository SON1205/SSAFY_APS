
import java.util.Scanner;

public class Cooker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//입력받기
			int N = sc.nextInt();
			
			int[][] food = new int[N][N];
			
			long total = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					food[i][j] = sc.nextInt();
					total += food[i][j];
				}
			}
			
			// 2 group: A & B
			// B의 합 = total - A의 합
			int[] idxes = new int[N / 2];
			
			for (int i = 0; i < idxes.length; i++) {
				idxes[i] = i;
			}
			
			long sumA = 0;
			
			long sumB = total - sumA;
			
			long min = 0;
			
			while (idxes[0] == 0) {
				
				for (int j = N / 2 - 1; j >= 0; j--) {
					if (idxes[j] < j + N / 2) {
						
						
						
						break;
					}
				}
				
				while (idxes[N / 2 - 1] == N - 1) {
					
					for (int p = 0; p < N / 2 - 1; p++) {
						for (int q = p + 1; q < N / 2; q++) {
							sumA = food[idxes[p]][idxes[q]] + food[idxes[q]][idxes[p]];
						}
					}
					
					if (min > Math.abs(sumA - sumB)) {
						min = Math.abs(sumA - sumB);
					}
					
					idxes[N / 2 - 1]++;
				}
				
				
				
				
			}
			
			System.out.println("#" + tc + " " + min);
		}
	}
}
