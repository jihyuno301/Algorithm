/*
Title : 탑
문제 :
수평 직선에 탑 N대를 세웠습니다. 모든 탑의 꼭대기에는 신호를 송/수신하는 장치를 설치했습니다. 발사한 신호는 신호를 보낸 탑보다 높은 탑에서만 수신합니다. 또한, 한 번 수신된 신호는 다른 탑으로 송신되지 않습니다.
예를 들어 높이가 6, 9, 5, 7, 4인 다섯 탑이 왼쪽으로 동시에 레이저 신호를 발사합니다. 그러면, 탑은 다음과 같이 신호를 주고받습니다. 높이가 4인 다섯 번째 탑에서 발사한 신호는 높이가 7인 네 번째 탑이 수신하고, 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신합니다. 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신할 수 없습니다.

- 배열의 마지막 원소부터 차례대로 꺼내서 사용하여야 하는 경우 스택을 이용한다.
- ArrayDeque에서 스택과 같은 방식으로 Element를 추가하려면 addFirst메소드를 사용한다.
 */
package Programmers.고득점Kit;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StackQueue_1 {
	public static int[] solution(int[] heights) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		ArrayDeque<Integer> temp = new ArrayDeque<>();
		int[] result = new int[heights.length];

		for(int h : heights) stack.addFirst(h);

		int top, left;
		while(!stack.isEmpty()) {
			top = stack.removeFirst();
			try {
				left = stack.peek();
			}
			catch(NullPointerException e) {
				temp.addFirst(0);
				break;
			}

			if(left > top) {
				temp.addFirst(stack.size());
			}
			else {
				ArrayDeque<Integer> a = new ArrayDeque<>();
				while(!stack.isEmpty()) {
					a.add(stack.removeFirst());
					try {
						if(stack.peek() >  top) break;
					}
					catch(NullPointerException e) { break;}
				}
				temp.addFirst(stack.size());
				while(!a.isEmpty()) {
					stack.addFirst(a.removeLast());
				}
			}
		}
		for(int i=0; i<result.length; i++) {
			result[i] = temp.removeFirst();
		}
		return result;
	}
	public static void main(String[] args) {
		int[] heights = {3, 9, 9, 3, 5, 7, 2};
		System.out.println(Arrays.toString(solution(heights)));
	}
}
