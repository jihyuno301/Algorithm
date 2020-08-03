/*
Title : 직사각형에서 탈출
URL : https://www.acmicpc.net/problem/1085
 */
package BaekJoon.Math;

import java.util.Scanner;

public class Q1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		System.out.println(Math.min(Math.min(x, w-x), Math.min(y, h-y)));
	}
}
