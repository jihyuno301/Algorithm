package BaekJoon.BruteForce;

import java.util.Scanner;

public class Q14889_1 {
	static int N;
	static int[][] boj;

	static int sharing(int[] team1, int idx1, int[] team2, int idx2, int player) {
		if(player >= N) {
			// 팀 능력차 구하기..
			return Math.abs(sum(team1) - sum(team2));
		}

		int ab1 = Integer.MAX_VALUE;
		int ab2 = Integer.MAX_VALUE;

		if(idx1 < N/2) {
			team1[idx1] = player;
			ab1 = sharing(team1, idx1+1, team2, idx2, player+1);
		}

		if(idx2 < N/2) {
			team2[idx2] = player;
			ab2 = sharing(team1, idx1, team2, idx2+1, player+1);
		}

		// 재귀 통해서 가져온 값과 비교
		return Math.min(ab1, ab2);
	}

	static int sum(int[] team) {
		int total = 0; // 능력치 합
		for(int n : team) {
			for(int k : team) {
				total += boj[n][k];
			}
		}
		return total;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		boj = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) boj[i][j] = sc.nextInt();
		}
		int result = sharing(new int[N/2], 0, new int[N/2], 0, 0);
		System.out.println(result);
	}
}
