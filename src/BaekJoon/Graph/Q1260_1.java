package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1260_1 {
	static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 시작할 정점의 번호

		matrix = new int[N][N]; // 인접행렬로 풀어보기

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;

			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}

		String result1 = DFS(V-1, new boolean[N], new StringBuffer());
		String result2 = BFS(V-1, new boolean[N], new StringBuffer());
		System.out.println(result1);
		System.out.println(result2);

	}

	static String DFS(int n, boolean[] visited, StringBuffer sb) { // n은 시작정점
		visited[n] = true;
		sb.append((n+1)+" ");
		for(int i=0; i<visited.length; i++) {
			if(matrix[n][i] == 1 && visited[i] == false) {
				DFS(i, visited, sb);
			}
		}
		return sb.toString();
	}

	static String BFS(int n, boolean[] visited, StringBuffer sb){ // n-1로 들어옴
		Deque<Integer> arrayDeque = new ArrayDeque<>();
		arrayDeque.add(n);
		sb.append((n+1)+" ");

		while(!arrayDeque.isEmpty()) {
			int tmp = arrayDeque.remove();
			visited[tmp] = true;

			for(int i=0; i<visited.length; i++) {
				if(matrix[tmp][i]==1 && visited[i]==false) {
					arrayDeque.add(i);
					visited[i] = true;
					sb.append((i+1)+" ");
				}
			}
		}

		return sb.toString();
	}

}
