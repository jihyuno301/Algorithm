/*
Title : AC
URL : https://www.acmicpc.net/problem/5430

- 메모리 초과로 인한 런타임 에러 주의
- 덱 이용, 실제로 뒤집지 말기
 */
package BaekJoon.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5430 {
	static void translateIntoAC(char[] func, Deque<Integer> deque) {
		boolean reverse = false; // 배열이 뒤집힌 경우는 true;

		for(char c : func) {
			// 숫자 뒤집기
			if( c == 'R') {
				reverse = !reverse;
			}
			if( c == 'D') {
				if(deque.size()==0) {
					System.out.println("error");
					return;
				}
				else {
					if(!reverse) deque.removeFirst();
					else deque.removeLast();
				}
			}
		}
		Iterator<Integer> iterator = (reverse ? deque.descendingIterator() : deque.iterator());
		String str = toString(iterator);
		System.out.println(str);
	}

	static String toString(Iterator<Integer> iterator) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		while (iterator.hasNext())
			builder.append(iterator.next()).append(",");
		if (builder.length() > 1) builder.deleteCharAt(builder.length() - 1); // 마지막 , 삭제
		return builder.append("]").toString();
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int i=0; i<T; i++) {
			Deque<Integer> deque = new ArrayDeque<>();

			char[] func = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine()," ,[]");
			for(int k=0; k<N; k++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			translateIntoAC(func,deque);
		}
	}
}
