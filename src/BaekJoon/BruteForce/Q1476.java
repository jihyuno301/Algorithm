/*
Title : 날짜 계산
URL : https://www.acmicpc.net/problem/1476

*/
package BaekJoon.BruteForce;

import java.util.Scanner;

public class Q1476 {

	static int solution(int E, int S, int M) {
		int year = 1;
		while(true) {
			// if((year % 15 == E) && (year % 28 == S) && (year % 19 == M)) return year; -> 시간 초과의 원인
			if((year-E)%15 == 0 && (year-S)%28 == 0 && (year-M)%19 == 0) {
				System.out.println(year);
				break;
			}
			year++;
		}
		return year;
	}

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();

		solution(E,S,M);
	}
}
