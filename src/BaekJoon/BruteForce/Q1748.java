/*
Title : 수 이어쓰기1
URL : https://www.acmicpc.net/problem/1748
 */
package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[String.valueOf(N).length()];
		for(int i=0; i<arr.length-1; i++) {
			arr[i] = (int) (Math.pow(10, i + 1) - Math.pow(10, i));
		}
		arr[arr.length-1] = N - (int)Math.pow(10,arr.length-1)+1;

		int total=0;
		for(int i=0; i<arr.length; i++) {
			total += arr[i]*(i+1);
		}
		System.out.println(total);
	}
}
