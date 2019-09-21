/*
Title : 숨바꼭질
URL : https://www.acmicpc.net/problem/1697
문제 : 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
입력 : 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
출력 : 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Q1697 {

	public static int bfs(int N, int K) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[K+1];
		int[] minTime = new int[K+1];

		queue.add(N);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			visited[current] = true;

			if(current==K) {
				return minTime[current];
			}

			int a = current-1;
			int b = current+1;
			int c = current*2;

			if(a>=0 && a<=K && !visited[a]) {
				queue.add(a);
				visited[a] = true;
				minTime[a] = minTime[current]+1;
			}
			if(b>=0 && b<=K && !visited[b]) {
				queue.add(b);
				visited[b] = true;
				minTime[b] = minTime[current]+1;
			}
			if(c>=0 && c<=K && !visited[c]) {
				queue.add(c);
				visited[c] = true;
				minTime[c] = minTime[current]+1;
			}
		}
		return 0;  // 동생의 위치를 찾지못한 경우
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		int K = Integer.parseInt(st.nextToken());// 동생의 위치
		System.out.println(bfs(N,K));
	}
}
