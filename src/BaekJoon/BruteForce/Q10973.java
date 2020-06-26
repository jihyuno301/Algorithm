/*
Title : 이전 순열
URL : https://www.acmicpc.net/problem/10973
 */
package BaekJoon.BruteForce;

import java.util.Scanner;

public class Q10973 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		if(prev_permutation(arr,N)) {
			for(int n : arr) {
				System.out.print(n+" ");
			}
			System.out.println();

		} else System.out.println(-1);
	}

	// 이전 순열 찾기
	static boolean prev_permutation(int[] arr, int n) {
		int i = n-1;
		// 첫순열인 경우 false 리턴
		while(i>0 && arr[i-1]<=arr[i]) i -= 1;
		if(i==0) return false;
		int j = n-1;
		while(arr[j]>=arr[i-1]) j -= 1;

		int tmp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = tmp;

		j = n-1;
		while(i<j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i += 1;
			j -= 1;
		}

		return true;
	}
}
