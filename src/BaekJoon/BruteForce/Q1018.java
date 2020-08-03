/*
Title : 체스판 다시 칠하기
URL ; https://www.acmicpc.net/problem/1018
 */
package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
	static char[][] arr;
	static char[][] case1 = {
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
	};
	static char[][] case2 = {
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr= new char[N][M];

		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		// 체스판 8 x 8 범위 정하기
		int result = Integer.MAX_VALUE;
		for(int r=0; r+7 < N; r++) {
			for(int c=0; c+7 < M; c++) {
				result = Math.min(result, getCount(r, r+7, c, c+7));
			}
		}

		System.out.println(result);

	}

	// 지민이가 다시 칠해야 하는 정사각형의 최소 개수 구하기
	static int getCount(int rx, int ry, int cx, int cy) {
		int cnt1 = 0;
		int cnt2 = 0;

		for(int aa=rx, ab=0; aa<=ry && ab<=case1.length; aa++, ab++) {
			for(int ba=cx, bb=0; ba<=cy && bb<=case1[0].length; ba++, bb++) {
				if(arr[aa][ba] != case1[ab][bb]) cnt1++;
				if(arr[aa][ba] != case2[ab][bb]) cnt2++;
			}
		}

		return Math.min(cnt1, cnt2);

	}
}
