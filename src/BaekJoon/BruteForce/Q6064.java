/*
Title : 카잉 달력
URL : https://www.acmicpc.net/problem/6064
*/
package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6064 {
	static int solution(int M, int N, int x, int y) {
		for(int year=1; year<= LCM(M,N); year++) {

			if((year%M==0 && x==M) || year%M==x) {
				if((year%N==0 && y==N) || year%N==y)  {
					return year;
				}
			}
		}
		return -1;
	}

	static int LCM(int M, int N) {
		int a= M;
		int b= N;
		int tmp;
		while(a != 0) {
			if(a < b) {
				tmp = a;
				a = b;
				b = tmp;
			}
			a = a % b;
		}
		return (M*N)/b;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			System.out.println(solution(M, N, x, y));
		}
	}
}
