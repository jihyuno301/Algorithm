/*
Title : 스타트와 링크
URL : https://www.acmicpc.net/problem/14889
 */
package BaekJoon.BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class Q14889 {

	static int[][] ability;

	static int sum(int[] team) {
		int total = 0;
		for(int t1 : team) {
			for(int t2 : team) {
				total += ability[t1][t2];
			}
		}
		return total;
	}
	static int solution(int[] team1, int idx1, int[] team2, int idx2, int player) {
		if(player >= ability.length) {
			System.out.println("team1:"+ Arrays.toString(team1));
			System.out.println("team2:"+ Arrays.toString(team2)+"\n");
			return Math.abs(sum(team1)- sum(team2));
		}
		int ab1 = Integer.MAX_VALUE, ab2 = Integer.MAX_VALUE;
		if(idx1 < team1.length) {
			team1[idx1] = player;
			ab1 = solution(team1, idx1+1, team2, idx2, player+1);
		}
		if(idx2 < team2.length) {
			team2[idx2] = player;
			ab2 = solution(team1, idx1, team2, idx2+1, player+1);
		}
		return Math.min(ab1, ab2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ability = new int[N][N];

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ability[i][j] = sc.nextInt();
			}
		}
		System.out.println(solution(new int[N/2], 0, new int[N/2], 0, 0));
	}
}
