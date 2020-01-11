package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2589 {
	static char[][] matrix;
	static int R, C;

	static class Node {
		int r;
		int c;
		int distance;

		public Node(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}

	public static Node solution(int row, int column) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];

		Node node = new Node(row,column,0);
		Node leafNode = null;
		queue.add(node);
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			int r = temp.r, c = temp.c, distance = temp.distance;
			if(r < 0 || r >= matrix.length) continue;
			if(c < 0 || c >= matrix[0].length) continue;
			if(visited[r][c]) continue;
			if(matrix[r][c]=='W') continue;
			visited[r][c]=true;
			leafNode = temp;
			queue.add(new Node(r+1, c, distance+1));
			queue.add(new Node(r-1, c, distance+1));
			queue.add(new Node(r, c+1, distance+1));
			queue.add(new Node(r, c-1, distance+1));
		}

		return leafNode;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		matrix = new char[R][C];
		for(int i=0; i<R; i++) {
			matrix[i] = br.readLine().toCharArray();
		}

		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(matrix[i][j]=='L')
					result = Math.max(result, solution(i, j).distance);
			}
		}
		System.out.println(result);
	}
}
