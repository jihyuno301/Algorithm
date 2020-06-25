/*
Title : 연결요소의 개수
URL ; https://www.acmicpc.net/problem/11724
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11724 {
	static ArrayList<Integer> arrayList[];
	static boolean[] visited;

	static void dfs(int i) {
		visited[i] = true;
		for(int n : arrayList[i]) {
			if(visited[n] == false) dfs(n);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int cnt = 0;

		arrayList = new ArrayList[N];
		visited = new boolean[N];

		for(int i=0; i<N; i++) {
			arrayList[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrayList[a-1].add(b-1);
			arrayList[b-1].add(a-1);
		}

		// 깊이 우선 탐색
		for(int i=0; i<N; i++) {
			if(visited[i]==false) {
				cnt++;
				dfs(i);
			}
		}

		System.out.println(cnt);
	}
}
