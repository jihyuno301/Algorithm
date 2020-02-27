/*
Title :  리모컨
URL : https://www.acmicpc.net/problem/1107
 */
package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1107 {
	static boolean[] buttons;

	static boolean isAbled(int N) {
		char[] channel = String.valueOf(N).toCharArray();
		for(char c : channel) {
			if(buttons[c-'0']) return false;
		}
		return true;
	}

	static int channel(int N) { //가까운 채널찾기
		if(isAbled(N)) return N;
		for(int i=0; i<=500000; i++) {
			if(N-i>=0 && isAbled(N-i)) return N-i;
			if(isAbled(N+i)) return N+i;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
		buttons = new boolean[10]; // 고장난 버튼

		if(M > 0) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				buttons[Integer.parseInt(st.nextToken())] = true;
			}
		}

		if(M==10) {
			System.out.println(Math.abs(N-100));
		} else {
			int channel = channel(N);
			int channel_length = String.valueOf(channel).length();
			int n1 = channel_length + Math.abs(N-channel);
			int n2 = Math.abs(N-100);
			System.out.println(Math.min(n1, n2));
		}
	}
}
