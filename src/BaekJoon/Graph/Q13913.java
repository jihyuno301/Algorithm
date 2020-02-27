/*
Title : 숨바꼭질4
URL : https://www.acmicpc.net/problem/13913

- Node 클래스에 각 노드까지의 경로를 저장하기 위한 StringBuilder 멤버변수를 선언하였더니 메모리 초과 및 시간 초과가 나왔다.

 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13913 {
	static class Node {
		int x;
		int distance;
		Node parent;

		public Node(int x, int distance, Node parent) {
			this.x = x;
			this.distance = distance;
			this.parent = parent;
		}
	}

	static void solution(int N, int K) {
		Deque<Node> deque = new ArrayDeque<>();
		Set<Integer> hashSet = new HashSet<>();

		deque.add(new Node(N,0, null));

		while(!deque.isEmpty()) {
			Node node = deque.remove();
			if(node.x == K) {
				System.out.println(node.distance);
				StringBuilder sb = new StringBuilder();
				while(node != null) {
					sb.insert(0, node.x+ " ");
					node = node.parent;
				}
				System.out.println(sb.toString());
				break;
			}
			if(node.x < 0 || node.x > 100000) continue;
			if(hashSet.contains(node.x)) continue;
			hashSet.add(node.x);

			deque.add(new Node(node.x*2, node.distance+1, node));
			deque.add(new Node(node.x+1, node.distance+1, node));
			deque.add(new Node(node.x-1, node.distance+1, node));
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		solution(N,K);
	}
}
