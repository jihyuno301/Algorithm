/*
Title : 나이트의 이동
URL : https://www.acmicpc.net/problem/7562
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {

	static class Vertex {
		int r, c, distance;

		public Vertex(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}

	static final int[][] moves = new int[][] {
			{+2,+1}, {+1,+2}, {+2,-1}, {+1,-2}, {-2,+1}, {-1,+2}, {-2,-1}, {-1,-2}
	};

	public static int solution(int I, int m0, int m1, int n0, int n1) {
		boolean[][] visited  = new boolean[I][I];
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(new Vertex(m0,m1,0));
		while(queue.size()>0) {
			Vertex vertex = queue.remove();
			if(vertex.r == n0 && vertex.c == n1) return vertex.distance;
			if(vertex.r < 0 || vertex.r >= I) continue;
			if(vertex.c < 0 || vertex.c >= I) continue;
			if(visited[vertex.r][vertex.c]) continue;
			visited[vertex.r][vertex.c] = true;
			for(int[] move : moves) {
				queue.add(new Vertex(vertex.r+move[0], vertex.c+move[1], vertex.distance+1));
			}
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int m0 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int n0 = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			System.out.println(solution(I, m0, m1, n0, n1));
		}
	}

}
