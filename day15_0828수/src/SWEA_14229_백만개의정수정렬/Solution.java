package SWEA_14229_백만개의정수정렬;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[1_000_000];
		int[] tmp = new int[1_000_000];
		
		for (int i = 0; i < 1_000_000; i++) {
			arr[i] = sc.nextInt();
		}
		
		mergeSort(arr, tmp, 0, arr.length - 1);
		
		System.out.println(arr[500_000]);
	}
	
	static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int mid = (start + end) / 2;
		mergeSort(arr, tmp,  start, mid);
		mergeSort(arr, tmp, mid + 1, end);
		merge(arr, tmp, start, mid, end);
	}
	
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		int L = start;
		int R = mid + 1;
		
		int idx = start;
		
		while (L <= mid && R <= end) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}
		
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= end; i++) {
				tmp[idx++] = arr[i];  
			}
		}
		
		//반영을 꼭 해주자
		for (int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
	}
}