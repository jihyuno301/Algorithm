/*
Title : 테트로미노
URL : https://www.acmicpc.net/problem/14500
 */
package BaekJoon.BruteForce;


import java.util.Scanner;

public class Q14500 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] mino = new int[N][M];

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				mino[i][j] = sc.nextInt();
			}
		}



	}
}
