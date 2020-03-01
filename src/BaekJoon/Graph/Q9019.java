/*
Title : DSLR
URL : https://www.acmicpc.net/problem/9019
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9019 {
	static class Node {
		int n;
		char c;
		Node parent;

		public Node(int n,char c, Node parent) {
			this.n = n;
			this.c = c;
			this.parent = parent;
		}
	}

	static String solution(int a, int b) {
		Deque<Node> arrayDeque = new ArrayDeque<>();
		Set<Integer> hashSet = new HashSet<>();

		arrayDeque.add(new Node(a, ' ', null));

		Node node = null;
		while(!arrayDeque.isEmpty()) {
			node = arrayDeque.remove();
			if(hashSet.contains(node.n)) continue;
			if(node.n > 10000) continue;
			if(node.n == b) break;
			hashSet.add(node.n);

			arrayDeque.add(new Node(commandD(node.n), 'D', node));
			arrayDeque.add(new Node(commandS(node.n), 'S', node));
			arrayDeque.add(new Node(commandL(node.n), 'L', node));
			arrayDeque.add(new Node(commandR(node.n), 'R', node));
		}

		StringBuilder sb = new StringBuilder();
		Node tmp = node;
		while(tmp != null) {
			sb.insert(0, tmp.c+"");
			tmp = tmp.parent;
		}
		return sb.toString();
	}

	static int commandD(int n) {
		return (2*n)%10000;
	}

	static int commandS(int n) {
		return n==0 ? 9999 : n-1;
	}

	// 왼쪽으로 회전
	static int commandL(int n) {
		if(n<10) System.out.println(n);
		// 두자릿수 이상인 자연수인 경우
		char[] number = String.valueOf(n).toCharArray();
		int N = number.length;
		char next = number[N-1];
		for(int i=N-1; i>0; i--) {
			char current = next;
			next = number[(i-1)%N];
			number[(i-1)%N] = current;
		}
		number[N-1] = next;

		StringBuilder sb = new StringBuilder();
		for(char c : number) {
			sb.append(c-'0');
		}
		return Integer.parseInt(sb.toString());
	}

	// 오른쪽으로 회전
	static int commandR(int n) {
		if(n<10) System.out.println(n);
		// 두자릿수 이상인 자연수인 경우
		char[] number = String.valueOf(n).toCharArray();
		int N = number.length;
		char next = number[0];
		for(int j=0; j<N; j++) {
			char current = next;
			next = number[(j+1)%N];
			number[(j+1)%N] = current;
		}

		StringBuilder sb = new StringBuilder();
		for(char c : number) {
			sb.append(c-'0');
		}
		return Integer.parseInt(sb.toString());
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			solution(a, b);
		}
	}
}
