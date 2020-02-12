/*
Title : 2xn 타일링
URL : https://www.acmicpc.net/problem/11726
 */
package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11726 {

	static final int MOD = 10007;
	static int solution(int n, int[] arr) {
		if(n==0) return 1;
		if(arr[n] >0) return arr[n];
		int cnt = 0;
		if(n>=2) cnt = (cnt+ solution(n-2, arr)) % MOD;
		cnt = (cnt+solution(n-1, arr)) % MOD;
		return arr[n] = cnt % MOD;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		System.out.println(solution(n, arr));
	}
}
