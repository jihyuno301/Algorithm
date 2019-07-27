/*
Title : 프린터 큐
문제 : https://www.acmicpc.net/problem/1966
 */
package BaekJoon.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //문서의 개수
			int M = Integer.parseInt(st.nextToken()); //몇번째로 인쇄되는지 찾고자 하는 문서의 위치
			int num = 0; //위치가 M인 문서의 중요도
			int count = 0;
			st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			while(st.hasMoreTokens()) {
				if(count==M) {
					num = Integer.parseInt(st.nextToken());
					queue.offer(num);
					count++;
				}
				else {
					queue.offer(Integer.parseInt(st.nextToken()));
					count++;
				}
			}
			count = 0; //초기화
			for(int j=0; j<N; j++) {
				if(queue.peek()>num) {
					queue.poll();
					++count;
				}
				else {
					queue.offer(queue.poll());
				}
			}

			System.out.println(count);
		}
	}
}
