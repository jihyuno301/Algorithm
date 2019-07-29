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
	public static class Document {
		int index;
		int value;

		public Document(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //문서의 개수
			int M = Integer.parseInt(st.nextToken()); //몇번째로 인쇄되는지 찾고자 하는 문서의 위치
			st = new StringTokenizer(br.readLine());
			Queue<Document> queue = new LinkedList<>();
			int index = 0;
			while(st.hasMoreTokens()) {
				Document document = new Document(index++, Integer.parseInt(st.nextToken()));
				queue.offer(document);
			}
			int count = 0;
			while(true) {
				Document document = queue.poll();
				int max = document.value;
				for(Document d : queue) {
					if (max < d.value) {
						max = d.value;
					}
				}
				if(document.value < max) {
					queue.offer(document);
				}
				else {
					++count;
					if(document.index == M) break;
				}
			}

			System.out.println(count);
		}
	}
}
