/*
Title : 이동하기
URL : https://www.acmicpc.net/problem/11048
 */
package BaekJoon.DP;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q11048 {
	static int solution(int N, int M, int[][] arr) {
		int[][] candies = new int[N][M];
		int[][] moves = {{0,1}, {1,0}, {1,1}};

		Deque<Node> arrayDeque = new ArrayDeque<>();
		arrayDeque.add(new Node(0,0, arr[0][0]));

		// queue가 빌 때 까지 다 확인해야함. 최댓값을 가져와야 하므로..
		while(!arrayDeque.isEmpty()) {
			Node node = arrayDeque.remove();
			// 이미 방문한 이력이 있어도 현재 가지고 있는 값과 새로운 값과 비교해야 함.
			candies[node.x][node.y] = node.z;
			for(int[] move : moves) {
				int x = node.x+move[0];
				int y = node.y+move[1];
				if(x < 0 || x >= N) continue;
				if(y < 0 || y >= M) continue;
				if(node.z + arr[x][y] < candies[x][y]) continue;
				arrayDeque.add(new Node(x, y, node.z+arr[x][y]));
			}
		}

		return candies[N-1][M-1];
	}

	static class Node {
		int x, y;
		int z; //candy
		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int result = solution(N, M, arr);
		System.out.println(result);
	}
}
