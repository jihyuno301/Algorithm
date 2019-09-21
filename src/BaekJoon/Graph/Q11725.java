/*
Title : 트리의 부모 찾기
URL : https://www.acmicpc.net/problem/11725
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11725 {
	static List<Integer>[] list;
	static int[] parents;
	static boolean[] visited;

	//이미 방문한 정점이 부모노드가 된다.
	public static void dfs(int node) {
		visited[node] = true;
		for(int i : list[node]) {
			if(!visited[i]) {
				parents[i] = node;
				dfs(i);
			}
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=1; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		//양방향 연결그래프로 구현
		for(int i=2; i<list.length; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		parents = new int[N+1];
		visited = new boolean[N+1];

		dfs(1);
		for(int i=2; i<parents.length; i++) {
			System.out.println(parents[i]);
		}

	}
}
