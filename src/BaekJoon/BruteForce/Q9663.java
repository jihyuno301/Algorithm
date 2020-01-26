/*
Title : N-Queen
URL : https://www.acmicpc.net/problem/9663
 */
package BaekJoon.BruteForce;

import java.util.Scanner;

public class Q9663 {

	static int col[];
	static int N;
	static int ans;

	// row 행까지는 퀸을 놓았다.
	// row+1 행에 퀸을 놓을 수 있는지 확인한다.
	static  void dfs(int row) {
		// 만약 row값이 N과 같다면 N 행까지 퀸을 놓았다는 말이므로 ans를 1증가시켜준다.
		if(row == N) {
			++ans;
		} else {
			// 1열 부터 N 열까지 반복하면서 (row+1, i)에 퀸을 놓을 수 있는경우가 있는지 확인한다.
			// 있으면 다음행의 dfs를 호출한다.
			for(int i=1; i<=N; i++) {
				// 현재 위치하고 있는 노드의 좌표를 저장 (i=행, c=열)
				col[row+1] = i;
				if(isPossible(row+1)) {
					dfs(row+1);
				}
			}
		}
	}

	// 퀸이 배치될 수 있는지 판단
	static boolean isPossible(int row) {
		// 1행부터 row 행까지 같은 열 혹은 대각선에 위치하는 퀸이 있는지 확인한다.
		for(int i=1; i<row; i++) {
			// i 행과 row 행의 열 값이 같으면 퀸을 놓을수 없다.
			if(col[i] == col[row]) return false;
			// 대각선
			if(Math.abs(col[i]-col[row]) == Math.abs(i-row)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		// 각 행에는 하나의 열에만 퀸이 놓여질 수 있다.
		// 1열부터 N열까지 돌면서 각 1행 N열에 퀸을 놓았을 때 가능한 경우의 수를 확인한다.
		for(int i=1; i<=N; i++) {
			col = new int[N+1];

			// 1행 i열에 퀸을 놓았다.
			col[1] = i;
			// 1행 i열에 퀸을 놓았을 경우 가능한 횟수
			dfs(1);
		}
		System.out.println(ans);
	}
}
