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
		if(n==1) return 1 % MOD;
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2; i<=n; i++) {
			arr[i] = (arr[i-1]+(arr[i-2]*2))%MOD;
		}
		return arr[n];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		System.out.println(solution(n, arr));
	}
}
