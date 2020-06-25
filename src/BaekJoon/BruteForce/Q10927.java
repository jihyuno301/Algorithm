/*
Title : 다음 순열
URL : https://www.acmicpc.net/problem/10972
 */
package BaekJoon.BruteForce;

import java.util.Scanner;

public class Q10927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		if(next_permutation(arr, N)) {
			for(int num : arr) System.out.print(num+" ");
			System.out.println();
		}
		else System.out.println(-1);
	}

	static boolean next_permutation(int[] arr, int n) {
		int i = n-1;
		// i-1 < i 구하기
		while(i>0 && arr[i-1] >= arr[i]) i -= 1;
		if(i<=0) return false; // 이미 마지막 순열인 경우
		int j = n-1; // 오른쪽에서 arr[i]보다 크면서 가장 작은 수
		while(arr[j] <= arr[i-1]) j -= 1;

		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;

		j = n-1;
		while(i<j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i += 1; j -= 1;
		}
		return true;
	}
}
