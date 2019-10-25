/*
Title : 미로탐색
URL : https://www.acmicpc.net/problem/2178
 */
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
	public static int solution(int[][] arr, int N, int M) {
		boolean[][] visited = new boolean[N][M];
		int[][] distance = new int[N][M];
		Queue<Miro> queue = new LinkedList<>();
		visited[0][0] = true;
		Miro miro = new Miro(0,0);
		queue.add(miro);
		distance[0][0] = 1;
		while(!queue.isEmpty()) {
			Miro temp1 = queue.poll();
			// 인덱스가 두자리인 것을 고려
			int i = temp1.getI();
			int j = temp1.getJ();

			// row-right
			Miro temp2;
			if( j+1<M && arr[i][j+1]==1 && !visited[i][j+1] ) {
				visited[i][j+1] = true;
				distance[i][j+1] = distance[i][j]+1;
				temp2 = new Miro(i,j+1);
				queue.add(temp2);
			}
			// row-left
			if( j-1>=0 && arr[i][j-1]==1 && !visited[i][j-1] ) {
				visited[i][j-1] = true;
				distance[i][j-1] = distance[i][j]+1;
				temp2 = new Miro(i,j-1);
				queue.add(temp2);
			}
			// column-down
			if( i+1<N && arr[i+1][j]==1 && !visited[i+1][j]) {
				visited[i+1][j] = true;
				distance[i+1][j] = distance[i][j]+1;
				temp2 = new Miro(i+1,j);
				queue.add(temp2);
			}

			// column-up
			if( i-1>=0 && arr[i-1][j]==1 && !visited[i-1][j] ) {
				visited[i-1][j] = true;
				distance[i-1][j] = distance[i][j]+1;
				temp2 = new Miro(i-1,j);
				queue.add(temp2);
			}
		}
		return distance[N-1][M-1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		System.out.println(solution(arr, N, M));
	}

	public static class Miro {
		int i = 0;
		int j = 0;
		public Miro(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return this.i;
		}

		public int getJ() {
			return this.j;
		}

	}
}
