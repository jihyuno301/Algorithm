/*
Title : 네트워크
URL : https://programmers.co.kr/learn/courses/30/lessons/43162
 */
package Programmers;

public class Graph_3 {
	static boolean[][] visited;
	static int solution(int n, int[][] computers) {
		visited = new boolean[n][n];
		int ans  = 0;

		for(int i=0; i<n; i++) {
			if(!visited[i][i]) {
				ans++;
				dfs(computers, i, n);
			}
		}
		return ans;
	}

	static void dfs(int[][] computers, int index, int n) {
		for(int i=0; i<n; i++) {
			if(computers[index][i] == 1 && !visited[index][i]) {
				visited[index][i] = visited[i][index] = true;
				dfs(computers, i, n);
			}
		}
	}
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0}, {1,1,0},{0,0,1}};
		solution(n, computers);
	}
}
