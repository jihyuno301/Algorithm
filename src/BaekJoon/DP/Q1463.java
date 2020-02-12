/*
Title : 1로 만들기
URL : https://www.acmicpc.net/problem/1463
 */
package BaekJoon.DP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1463 {
	static int solution(int n) {
		Queue<Integer> queue = new LinkedList<>();
		int[] distance = new int[n+1];

		queue.add(n);
		while(!queue.isEmpty()) {
			int tmp = queue.remove();
			if(tmp == 1) {
				break;
			}
			if(tmp%2 == 0 && distance[tmp/2] == 0) {
				distance[tmp/2] = distance[tmp]+1;
				queue.add(tmp/2);
			}
			if(tmp%3 == 0 && distance[tmp/3] == 0) {
				distance[tmp/3] = distance[tmp]+1;
				queue.add(tmp/3);
			}
			if(tmp-1 > 0 && distance[tmp-1] == 0) {
				distance[tmp-1] = distance[tmp]+1;
				queue.add(tmp-1);
			}
		}
		return distance[1];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}
}
