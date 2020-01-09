/*
Title : 상범빌딩
URL : https://www.acmicpc.net/problem/6593
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q6593 {
	static class Vertex {
		int l, r, c, distance;

		public Vertex(int l, int r, int c, int distance) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		@Override
		public int hashCode() {
			return Objects.hash(l, r, c);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null || getClass() != obj.getClass()) return false;
			Vertex vertex = (Vertex) obj;
			return l==vertex.l && r==vertex.r && c==vertex.c;
		}
	}

	static int[][][] moves = {{{0,0,+1}}, {{0,0,-1}}, {{0,-1,0}}, {{0,+1,0}}, {{1,0,0}}, {{-1,0,0}}};
	static int bfs(char[][][] building, int[] start, int[] end) {
		Queue<Vertex> queue = new LinkedList<>();
		Set<Vertex> hashSet = new HashSet<>();  //방문한 정점들의 집합

		Vertex S = new Vertex(start[0],start[1],start[2],0);
		queue.add(S);

		while(!queue.isEmpty()) {
			Vertex vertex = queue.remove();
			if(building[vertex.l][vertex.r][vertex.c] == '#') continue;
			if(building[vertex.l][vertex.r][vertex.c] == 'E') return vertex.distance;
			if(hashSet.contains(vertex)) continue;
			hashSet.add(vertex);
			for(int[][] layer : moves) { //하나의 층
				for(int[] row : layer) {
					int l1 = vertex.l + layer[0][0];
					int r1 = vertex.r + row[0];
					int c1 = vertex.r + row[1];

					if(l1<0 || l1>=building.length) continue;
					if(r1<0 || r1>= building[0].length) continue;
					if(c1<0 || c1>=building[0][0].length) continue;

					queue.add(new Vertex(l1,r1,c1,vertex.distance+1));
				}
			}
		}
		return -1;

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if(L==0 && R==0 && C==0) break;

			char[][][] building = new char[L][R][C];
			int[] start = new int[3];
			int[] end = new int[3];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					char[] temp = br.readLine().toCharArray();
					for (int k = 0; k<C; k++) {
						if(temp[k]=='S') start[0]=i; start[1]=j; start[2]=k;
						if(temp[k]=='E') end[0]=i; end[1]=j; end[2]=k;
						building[i][j][k] = temp[k];
					}
				}
				br.readLine();
			}
			int result = bfs(building, start, end);
			if(result == -1) System.out.println("Trapped!");
			else System.out.println(String.format("Escaped in %d minute(s).", result));
		}
	}

}
