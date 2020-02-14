/*
Title : 1,2,3 더하기
URL : https://www.acmicpc.net/problem/9095
 */
package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {
	//n은 양수이고 11보다 작다.
	static int solution(int n) {
		if(n == 1) return 1;

		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;

		for(int i=2; i<=n; i++) {
			if(i==2) dp[i] = dp[i-1]+dp[i-2];
			else {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
		}

		return dp[n];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			System.out.println(solution(n));
		}
	}
}
