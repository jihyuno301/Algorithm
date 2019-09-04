/*
Title : 수 찾기
URL : https://www.acmicpc.net/problem/1920
 */
package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {
	public static int binarySearch(int[] list, int findNum) {
		int left = 0;
		int right = list.length-1;
		int mid = 0;
		while(left<=right) {
			mid = (left+right)/2;
			if(list[mid]==findNum) return 1;
			else {
				if(findNum<list[mid]) right = mid-1;
				else left = mid+1;
			}
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] list1 = new int[N];
		int i=0;
		while(st.hasMoreTokens()) {
			list1[i++] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list1);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] list2 = new int[M];
		i=0;
		while(st.hasMoreTokens()) {
			list2[i++] = Integer.parseInt(st.nextToken());
		}

		for(i=0; i<M; i++) {
			System.out.println(binarySearch(list1, list2[i]));
		}
	}
}
