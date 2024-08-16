package prac;

public class Prac {
	static int N;
	static boolean[] isSelected;
	
	static void dfs(int cnt) {
		if (cnt == N) {
			if (checking()) {
				for (int i = 0; i < isSelected.length; i++) {
					if (isSelected[i]) {
						System.out.print(i + " ");
					}
				}
				System.out.println();
			}
			
			return;
		}
		
		isSelected[cnt] = true;
		dfs(cnt + 1);
		isSelected[cnt] = false;
		dfs(cnt + 1);
	}
	
	public static void main(String[] args) {
		N = 4;
		isSelected = new boolean[N];
		
		dfs(0);
	}
	
	static boolean checking() {
		int cnt = 0;
		
		for (int i = 0; i < isSelected.length; i++) {
			if (isSelected[i]) {
				cnt++;
			}
		}
		
		if (cnt == 0 || cnt > isSelected.length / 2) {
			return false;
		}
		
		return true;
	}
}
