/*
Title : 토마토
URL : https://www.acmicpc.net/problem/7576
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
	static int R, C;
	static int[][] box;

	static class Node {
		int r, c, distance;

		Node(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}

	static int solution(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];

		Node node = new Node(r,c,0);
		Node lastNode = null;
		queue.add(node);
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			System.out.println("distance : "+temp.distance);
			int N = temp.r; int M = temp.c; int K = temp.distance;
			if(N < 0 || N >= R) continue;
			if(M < 0 || M >= C) continue;
			if(box[N][M] == -1) continue;
			if(box[N][M] == 0) box[N][M] = 1 ;
			if(visited[N][M]) continue;
			visited[N][M] = true;
			lastNode = temp;

			queue.add(new Node(N+1, M, K+1));
			queue.add(new Node(N-1, M, K+1));
			queue.add(new Node(N, M+1, K+1));
			queue.add(new Node(N, M-1, K+1));
		}
		return lastNode.distance;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken()); //
		R = Integer.parseInt(st.nextToken());
		box = new int[R][C];

		int minDays = 0;
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) box[i][j] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(box[i][j]==1) {
					System.out.println(String.format("index : %d %d", i, j));
					minDays += solution(i,j);
				}
				System.out.println(minDays);
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(minDays);
	}
}
