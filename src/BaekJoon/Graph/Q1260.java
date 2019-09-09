/*
Title : DFS와 BFS
URL : https://www.acmicpc.net/problem/1260
문제 : 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
입력 : 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
출력 : 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {
	static void DFS(List<Integer>[] list, int start) {
		//방문한 정점 확인
		boolean[] visited = new boolean[list.length];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		//스택이 빌 때까지 진행
		//스택에 value가 남아있는 경우 아직 방문해야 하는 정점이 남아있음을 의미
		while(stack.size()>0) {
			//현재정점
			int current = stack.pop();
			//현재정점을 방문하였다면 pass~
			if(visited[current]) continue;
			//현재정점 방문
			visited[current] = true;
			System.out.print((current+1)+" ");
			//방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문


		}


	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken())-1;
		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i=0; i<N; i++)
			list[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			list[a].add(b); //두 정점 사이의 간선
			list[b].add(a);
		}

	}
}
