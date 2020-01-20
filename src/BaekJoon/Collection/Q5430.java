/*
Title : AC
URL : https://www.acmicpc.net/problem/5430

- 덱 이용, 실제로 뒤집지 말기
 */
package BaekJoon.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Q5430 {
	static String translateIntoAC(char[] func, int[] arr) {
		Queue<Character> queue = new LinkedList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		boolean reverse = false; // 배열이 뒤집힌 경우는 true;

		if(arr.length == 0) return Arrays.toString(arr);

		for(char c : func) queue.add(c);
		for(int n : arr) deque.add(n);

		while(!queue.isEmpty()) {
			char c = queue.remove();
			// 숫자 뒤집기
			if( c == 'R') {
				if(reverse == false) reverse = true;
				else reverse = false;
			}
			if( c == 'D') {
				if(deque.size()==0) return "error";
				else {
					if(reverse == false) deque.removeFirst();
					else deque.removeLast();
				}
			}
		}
		if(reverse == true) { // 배열이 뒤집어 있다면
			StringBuilder sb = new StringBuilder("[");
			while(deque.size()>1) {
				sb.append(deque.removeLast());
				sb.append(",");
			}
			sb.append(deque.removeLast());
			sb.append("]");
			return sb.toString();
		}
		else return deque.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int i=0; i<T; i++) {
			char[] func = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine()," ,[]");
			for(int k=0; k<n; k++) {
				int value = Integer.parseInt(st.nextToken());
				arr[k] = value;
			}
			translateIntoAC(func,arr);
		}
	}
}
