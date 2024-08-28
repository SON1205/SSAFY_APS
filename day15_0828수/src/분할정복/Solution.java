package 분할정복;

import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		int[] arr = {14, 2, 4, 20, 45, 7};
//		int[] result = new int[arr.length];
		
		quickSort(arr, 0, arr.length -1);
		
//		mergeSort(arr, result, 0, arr.length - 1);
		
//		mergeSort2(arr, result, 0, arr.length - 1);
		
		System.out.println(Arrays.toString(arr));
		
//		System.out.println(Arrays.toString(result));
		
	}
	
//	static void mergeSort2(int[] arr, int[] tmp, int start, int end) {
//		if (start < end) {
//			int mid = (start + end) / 2;
//			mergeSort2(arr, tmp, start, mid);
//			mergeSort2(arr, tmp, mid + 1, end);
//			merge(arr, tmp, start, mid, end);
//		}
//	}

	//병합정령
	static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int mid = (start + end) / 2;
		mergeSort(arr, tmp,  start, mid);
		System.out.println(start + " " + mid + " ");
		System.out.println(Arrays.toString(tmp));
		mergeSort(arr, tmp, mid + 1, end);
		System.out.println((mid + 1) + " " + end + " ");
		System.out.println(Arrays.toString(tmp));
		merge(arr, tmp, start, mid, end);
		System.out.println(start + " " + mid + " " + end);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(tmp));
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
	
	//퀵정렬
	static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
//			int pivot = partition(arr, start, end);
			int pivot = partition2(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		
		int L = start + 1;
		int R = end;
		
		while (L <= R) {
			while (L <= R && arr[L] <= pivot) {
				L++;
			}
			
			while (arr[R] > pivot) {
				R--;
			}
			
			if (L < R) {
				int num = arr[L];
				arr[L] = arr[R];
				arr[R] = num;
			}
		}
		
		int num = arr[start];
		arr[start] = arr[R];
		arr[R] = num;
		
		return R;
	}
	
	private static int partition2(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left - 1; //작은 값들의 경계
		
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		int tmp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = tmp;
		return i + 1;
	}
}