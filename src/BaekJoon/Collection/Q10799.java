/*
Title : 쇠막대기
문제 : https://www.acmicpc.net/problem/10799
 */
package BaekJoon.Collection;

import java.util.Scanner;
import java.util.Stack;
public class Q10799 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();

		Stack<Character> stack = new Stack<>();
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='(') stack.push(str.charAt(i));
			else { //')'인 경우
				if(str.charAt(i-1)=='(') {
					stack.pop();
					count += stack.size();
				}
				else {
					stack.pop();
					++count;
				}
			}
		}
		System.out.println(count);
	}
}
