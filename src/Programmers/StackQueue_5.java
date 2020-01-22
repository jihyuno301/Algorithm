/*
Title : 쇠막대기
URL : https://programmers.co.kr/learn/courses/30/lessons/42585
*/
package Programmers;

import java.util.Stack;

public class StackQueue_5 {
	static int solution(String arrangement) {
		char[] arr = arrangement.toCharArray();
		Stack<Character> stack = new Stack<>();

		int cnt = 0;
		char tmp = '(';
		for(char c : arr) {
			if(c == '(') stack.push(c);
			else {
				stack.pop();
				// 직전 문자가 '('라면
				if(tmp == '(') cnt += stack.size();
				else cnt += 1;
			}
			tmp = c;
		}
		return cnt;
	}
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}
}
