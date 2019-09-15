/*
Title : 바이러스
URL : https://www.acmicpc.net/problem/2606
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Q2606 {
	public static int solution(List<Integer>[] list, int start) {
		int cnt = -1; //바이러스에 감염된 컴퓨터의 수, start 정점을 제외시키기 위해
		boolean[] visited = new boolean[list.length];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.push(start);
		while(queue.size() > 0) {
			int current = queue.removeFirst();
			if(visited[current]==true) continue;
			visited[current] = true;
			++cnt;
			for(int child : list[current]) {
				queue.push(child);
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a-1].add(b-1);
			list[b-1].add(a-1);
		}
		System.out.println(solution(list, 0));

	}
}
