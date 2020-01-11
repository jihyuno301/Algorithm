package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2589 {

	static char[][] matrix;

	static class Node {
		int r;
		int c;
		int distance;

		public Node(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, c);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null || getClass() != obj.getClass()) return false;
			Node node = (Node) obj;
			return r==node.r && c==node.c;
		}
	}

	public static int solution(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();

		Node node = new Node(r,c,0);
		queue.add(node);
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			if(visited.contains(temp)) continue;

		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		matrix = new char[r][c];
		for(int i=0; i<r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				matrix[i][j] = temp[j];
			}
		}

		Set<Integer> time = new HashSet<>();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(matrix[i][j]=='W') continue;
				int result = solution(int r, int c);
				time.add(result);
			}
		}

	}
}
