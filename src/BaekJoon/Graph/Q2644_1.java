/*
Title : 촌수계산
URL : https://www.acmicpc.net/problem/2644
 */

package BaekJoon.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2644_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int A = scan.nextInt();
		int B = scan.nextInt();
		int E = scan.nextInt();

		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			list[a].add(b);
			list[b].add(a);
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];

		queue.add(A);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(visited[current]) continue;
			visited[current] = true;
			for(int n : list[current]) {
				if(!visited[n]) {
					queue.add(n);
					distance[n] = distance[current] + 1;
					System.out.println("current:" + current + "n:" + n + "distance[n]:" + distance[n]);
				}
			}
		}
		System.out.println(distance[B]);
	}
}