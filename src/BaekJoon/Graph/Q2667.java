///*
//Title : 단지번호붙이기
//URL : https://www.acmicpc.net/problem/2667
// */
//package BaekJoon.Graph;
//
//import java.util.Scanner;
//
//public class Q2667 {
//
//	static int N;
//	static char[][] map;
//	static boolean[][] visited;
//	static int[][] move = {{+1,0}, {-1,0}, {0, +1}, {0, -1}};
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		map = new char[N][N];
//		visited = new boolean[N][N];
//		int cnt = 0; // 단지 수
//		char num = '2'; // 단지 번호 부여
//
//		for(int i=0; i<N; i++) {
//			map[i] = sc.next().toCharArray();
//		}
//
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				if(visited[i][j]==false && map[i][j]=='1') { // 방문하지 않았고, 집이 있는 경우
//					cnt++; // 단지 수 count
//					dfs(i, j, num);
//					num++;
//				}
//			}
//		}
//
//		System.out.println(cnt);
//	}
//
//	static int dfs(int r, int c, char num) { // num은 단지 번호, cnt는 집 수
//		// 종료조건
//		if(r<0 || r>=N) return 0;
//		if(c<0 || c>=N) return 0;
//		if(map[r][c] != '1') return 0;
//
//		// 현재작업단계
//		visited[r][c] = true;
//		map[r][c] = num;
//
//		// 인접해 있는 정점들로 dfs 호출
//		for(int[] m : move) {
//			if ((r + m[0]) >= 0 && (r + m[0]) < N && (c + m[1]) >= 0 && (c + m[1]) < N) {
//				if (visited[r + (m[0])][c + (m[1])] == false && map[r + (m[0])][c + (m[1])] == '1') {
//					dfs(r + m[0], c + m[1], num, cnt+1);
//				}
//			}
//		}
//
//		return cnt;
//
//	}
//
//}
