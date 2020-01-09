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

	static int[][] moves = {{0,0,+1}, {0,0,-1}, {0,-1,0}, {0,+1,0}, {1,0,0}, {-1,0,0}};
	static int bfs(char[][][] building, int[] start) {
		Queue<Vertex> queue = new LinkedList<>();
		Set<Vertex> hashSet = new HashSet<>();  //방문한 정점들의 집합

		Vertex S = new Vertex(start[0],start[1],start[2],0);
		queue.add(S);
		while(!queue.isEmpty()) {
			Vertex vertex = queue.remove();
			if(building[vertex.l][vertex.r][vertex.c] == '#') continue;
			if(building[vertex.l][vertex.r][vertex.c] == 'E') return vertex.distance;
			if(hashSet.contains(vertex)) continue;
			hashSet.add(vertex); // 방문한 정점

			for(int[] move : moves) {
				// {{0,0,+1}, {0,0,-1}, {0,-1,0}, {0,+1,0}, {1,0,0}, {-1,0,0}};
				int L = vertex.l + move[0];
				int R = vertex.r + move[1];
				int C = vertex.c + move[2];

				if(L<0 || L>=building.length) continue;
				if(R<0 || R>= building[0].length) continue;
				if(C<0 || C>=building[0][0].length) continue;

				// 목적지 E까지 가는 것을 큐에 추가하지 않아서 오류발생
				if(building[L][R][C] == '.' || building[L][R][C]=='E') {
					queue.add(new Vertex(L, R, C, vertex.distance + 1));
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
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					char[] temp = br.readLine().toCharArray();
					for (int k = 0; k<C; k++) {
						if(temp[k]=='S') {
							start[0]=i;
							start[1]=j;
							start[2]=k;
						}
						building[i][j][k] = temp[k];
					}
				}
				br.readLine();
			}
			int result = bfs(building, start);
			if(result == -1) System.out.println("Trapped!");
			else System.out.println(String.format("Escaped in %d minute(s).", result));
		}
	}

}
