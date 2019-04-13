package Sort;
/*
 * 퀵정렬 연습 - pivot이 맨 뒤의 값인 경우
 */
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {34,13,19,5,42,22,18};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i=start-1; //pivot보다 작은 값들의 마지막 인덱스
		for(int j=start; j<=end-1; j++) {
			if(arr[j]<pivot) swap(arr, ++i, j);
		}
		swap(arr, i+1, end); 
		return i+1;
	}
	
	public static void quickSort(int[] arr, int a, int b) {
		//재귀 종료조건
		if(a>=b) return;
		int pivot_idx = partition(arr, a, b);
		quickSort(arr, a, pivot_idx-1);
		quickSort(arr, pivot_idx+1, b);
	}
	
	
}
