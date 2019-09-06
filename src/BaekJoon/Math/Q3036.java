/*
Title : 링
URL : https://www.acmicpc.net/problem/3036
기약분수 : 더 이상 약분이 안되는 분수. 즉, 최대공약수로 나누어 준다.
 */

package BaekJoon.Math;

import java.util.Scanner;

public class Q3036 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] radius = new int[N];
		for(int i=0; i<N; i++) {
			radius[i] = scan.nextInt();
		}
		int a = radius[0];
		for(int i=1; i<N; i++) {
			int gcd = GCD(a, radius[i]);
			System.out.printf("%d/%d \n", a/gcd, radius[i]/gcd);
		}
	}
	// a가 b보다 크다는 것을 가정
	private static int GCD(int a, int b) {
		while(b!=0) {
			int s = a % b;
			a = b;
			b = s;
		}
		return a;
	}
}
