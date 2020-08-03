/*
Title : 수 찾기
URL : https://www.acmicpc.net/problem/1920
 */
package BaekJoon.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Q1920_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N;
		int M;
		int[] case1;
		int[] case2;

		N = sc.nextInt();
		case1 = new int[N];
		for(int i=0; i<N; i++) {
			case1[i] = sc.nextInt();
		}

		M = sc.nextInt();
		case2 = new int[M];
		for(int i=0; i<M; i++) {
			case2[i] = sc.nextInt();
		}

		Arrays.sort(case1);

		for(int n : case2) {
			System.out.println(binarySearch(case1, n));
		}


	}

	static int binarySearch(int[] arr, int num) {
		int left = 0;
		int right = arr.length-1;
		int mid = 0;
		while(left<=right) {
			mid = (left+right)/2;
			if(arr[mid]==num) return 1;
			else {
				if(num<arr[mid]) right = mid-1;
				else left = mid+1;
			}
		}
		return 0;

	}
}
