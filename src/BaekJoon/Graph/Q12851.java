/*
Title : 숨바꼭질2
URL : https://www.acmicpc.net/problem/12851
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12851 {

	static final int MAX = 100000;
	static int minTime = Integer.MAX_VALUE;
	static int count = 0;

	static void solution(int start, int end) {
		Deque<Node> arrayDeque = new ArrayDeque<>();
		int[] visited = new int[MAX+1];
		Arrays.fill(visited, Integer.MAX_VALUE);

		arrayDeque.add(new Node(start, 0));
		while(!arrayDeque.isEmpty()) {
			Node node = arrayDeque.remove();
			if(node.x == end) {
				if(count == 0) minTime = node.d;
				++count;
			}
			if(node.d > minTime) return;
			if(node.x < 0 || node.x > MAX) continue;
			if(visited[node.x] < node.d) continue;
			visited[node.x] = node.d;
			arrayDeque.add(new Node(node.x-1, node.d+1));
			arrayDeque.add(new Node(node.x+1, node.d+1));
			arrayDeque.add(new Node(node.x*2, node.d+1));
		}
	}
	static class Node {
		int x;
		int d;

		public Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		solution(a, b);
		System.out.println(minTime);
		System.out.println(count);

	}
}
