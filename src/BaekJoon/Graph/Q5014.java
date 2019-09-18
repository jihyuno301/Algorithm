/*
Title : 스타트링크
URL : https://www.acmicpc.net/problem/5014
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // F층 건물
		int S = Integer.parseInt(st.nextToken()); // 강호의 위치
		int G = Integer.parseInt(st.nextToken()); // 회사사무실 위치
		int U = Integer.parseInt(st.nextToken()); // up 버튼
		int D = Integer.parseInt(st.nextToken()); // down 버튼

		// ArrayDeque로 채점안됨
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[F+1];
		int[] buttonCount = new int[F+1];
		queue.add(S);
		while(queue.size()>0) {
			int current = queue.poll();
			visited[current] = true;

			if(current == G) {
				System.out.println(buttonCount[current]);
				return;
			}
			if((current+U)<=F && !visited[current+U]) {
				buttonCount[current+U] = buttonCount[current]+1;
				visited[current+U] = true;
				queue.add(current+U);
			}
			if((current-D)>0 && !visited[current-D]) {
				buttonCount[current-D] = buttonCount[current]+1;
				visited[current-D] = true;
				queue.add(current-D);
			}

		}
		System.out.println("use the stairs");
	}
}
