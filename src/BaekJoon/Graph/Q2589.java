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

	public static int solution(int row, int column) {
		Queue<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();

		Node node = new Node(row,column,0);
		queue.add(node);
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			if(visited.contains(temp)) continue;
			if(temp.r < 0 || temp.r >= matrix.length) continue;
			if(temp.c < 0 || temp.c >= matrix[0].length) continue;
			if(matrix[temp.r][temp.c]=='W') continue;
			visited.add(temp);
			queue.add(new Node(temp.r+1, temp.c, temp.distance+1));
			queue.add(new Node(temp.r-1, temp.c, temp.distance+1));
			queue.add(new Node(temp.r, temp.c+1, temp.distance+1));
			queue.add(new Node(temp.r, temp.c-1, temp.distance+1));
		}

		Iterator<Node> iterator = visited.iterator();
		int time = 0;
		while(iterator.hasNext()) {
			int temp = iterator.next().distance;
			if(temp > time) time = temp;
		}
		return time;
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
				int result = solution(i, j);
				time.add(result);
			}
		}

		Iterator<Integer> iterator = time.iterator();
		int result = 0;
		while(iterator.hasNext()) {
			int temp = iterator.next();
			if(temp > result) result = temp;
		}
		System.out.println(result);
	}
}
