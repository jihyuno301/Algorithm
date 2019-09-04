/*
Title : 나무 자르기
URL : https://www.acmicpc.net/problem/2805
알고리즘 분류 : 이분탐색으로 최댓값 찾기
 */
package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 나무의 수, 필요로 하는 나무의 길이
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 나무의 높이
		st = new StringTokenizer(br.readLine());
		int[] trees = new int[N];
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);
		System.out.println(findMaxHeight(trees,M));
	}

	public static long findMaxHeight(int[] trees, int M) {
		int min = trees[0];
		int max = trees[trees.length-1];
		int mid;
		while(min<=max) {
			mid = (min+max)/2;
			int cutTree;
			long sumCutTree = 0;
			for(int i=0; i<trees.length; i++) {
				cutTree = trees[i]-mid;
				if(cutTree<0) cutTree= 0;
				sumCutTree += cutTree;
			}
			if(sumCutTree >= M) min = mid+1;
			else  max = mid-1;
		}
		return max;
	}
}
