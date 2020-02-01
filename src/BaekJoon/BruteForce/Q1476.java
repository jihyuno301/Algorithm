/*
Title : 날짜 계산
URL : https://www.acmicpc.net/problem/1476

- 시간초과 오류
*/
package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1476 {
	static int solution(int E, int S, int M) {
		int year = 1;
		while(true) {
			if((year % 15 == E) && (year % 28 == S) && (year % 19 == M)) return year;
			year++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		System.out.println(solution(E,S,M));
	}
}
