package BaekJoon.DP;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q1463_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(solution(N));
	}

	static int solution(int n) {
		Deque<Integer> arrayDeque = new ArrayDeque<>();
		int[] distance = new int[n+1];

		arrayDeque.addLast(n);
		while(!arrayDeque.isEmpty()) {
			int tmp = arrayDeque.removeFirst();
			if(tmp == 1) break;
			if(tmp % 2 == 0 && distance[tmp/2] == 0) {
				arrayDeque.addLast(tmp/2);
				distance[tmp/2] = distance[tmp]+1;
			}
			if(tmp % 3 == 0 && distance[tmp/3] == 0) {
				arrayDeque.addLast(tmp/3);
				distance[tmp/3] = distance[tmp]+1;
			}
			if(tmp > 1 && distance[tmp-1] == 0) {
				arrayDeque.addLast(tmp-1);
				distance[tmp-1] = distance[tmp]+1;
			}
		}

		return distance[1];
	}
}
