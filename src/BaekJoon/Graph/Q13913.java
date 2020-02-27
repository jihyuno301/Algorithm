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
		StringBuilder sb = new StringBuilder();

		public Node(int x, int distance, StringBuilder sb) {
			this.x = x;
			this.distance = distance;
			if(sb != null) this.sb.append(sb);
			this.sb.append(x+" ");
		}

		@Override
		public String toString() {
			return sb.toString();
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
				System.out.println(node.toString());
				break;
			}
			if(hashSet.contains(node.x)) continue;
			hashSet.add(node.x);

			deque.add(new Node(node.x*2, node.distance+1, node.sb));
			deque.add(new Node(node.x+1, node.distance+1, node.sb));
			deque.add(new Node(node.x-1, node.distance+1, node.sb));
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
