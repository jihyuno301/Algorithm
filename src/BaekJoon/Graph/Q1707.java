/*
Title : 이분 그래프
URL : https://www.acmicpc.net/problem/1707
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1707 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수

			// 인접리스트 방식으로 구현
			boolean[] visited = new boolean[V];
			int[] binary = new int[V]; // 1,2로 구분
			ArrayList<Integer>[] list = new ArrayList[V];

			for(int j=0; j<V; j++) {
				list[j] = new ArrayList<>();
			}

			for(int j=0; j<E; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;

				list[a].add(b);
				list[b].add(a);
			}

			for(int j=0; j<V; j++) {
				if(visited[j] == false) dfs(j, visited, binary, 1, list);
			}

			boolean result = true;
			for(int j=0; j<V; j++) {
				for(int c : list[j]) {
					if(binary[j] == binary[c]) result = false; // 인접정점이 같은 color이면,
				}
			}

			if(result) System.out.println("YES");
			else System.out.println("NO");

		}


	}

	static void dfs(int n, boolean[] visited, int[] binary, int color,  ArrayList<Integer>[] list) {
		visited[n] = true;
		binary[n] = color;

		for(int c : list[n]) {
			if(visited[c] == false) {
				dfs(c, visited, binary, 3-color, list);
			}
		}
	}

}
