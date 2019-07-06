/*
 * Title : 짝수, 홀수 분리하기
 * int형 배열로 입력을 받아서 짝수는 왼쪽, 홀수는 오른쪽으로 정렬되게 하라
 */

import java.util.Scanner;


public class P01 {
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("입력받을 숫자의 개수 : ");
		int N = input.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = input.nextInt();
		}
		
		int start = -1; //짝수 마지막값
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2==0) swap(arr,++start, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]+" ");
		}
		sb.append("\n");
		System.out.print(sb.toString());
		
		
	}
}
