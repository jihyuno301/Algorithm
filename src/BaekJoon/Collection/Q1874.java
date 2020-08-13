/*
Title : 스택 수열
URL : https://www.acmicpc.net/problem/1874
 */
package BaekJoon.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Q1874 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sequence = new int[N];
		int maxNum = 0;
		boolean flag = true;
		List<Character> list = new ArrayList<>();

		for(int i=0; i<N; i++) {
			sequence[i] = sc.nextInt();
		}

		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			int num = sequence[i];
			if(maxNum < num) {
				while(maxNum < num) {
					maxNum += 1;
					stack.push(maxNum);
					list.add('+');
				}
			}

			if(maxNum >= num) {
				if(stack.pop() == num) {
					list.add('-');
				} else {
					flag = false;
					break;
				}
			}

		}

		if(!flag) System.out.println("NO");
		else {
			for(char c : list) System.out.println(c);
		}
	}
}
