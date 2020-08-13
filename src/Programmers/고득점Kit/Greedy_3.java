/*
Title : 큰 수 만들기
URL : https://programmers.co.kr/learn/courses/30/lessons/42883
 */
package Programmers.고득점Kit;

import java.util.Stack;

public class Greedy_3 {
	static String solution(String number, int k) {

		char[] arr = number.toCharArray();
		Stack<Character> stack = new Stack<>();

		for(char c : arr) {
			while(!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}

		StringBuilder result = new StringBuilder();
		for(Character c : stack) {
			result.append(c);
			if(result.length() == number.length()-k) break;
		}
		return result.toString();
	}
	public static void main(String[] args) {
		String number = "1231234";
		int K = 3;
		System.out.println(solution(number, K));
	}
}
