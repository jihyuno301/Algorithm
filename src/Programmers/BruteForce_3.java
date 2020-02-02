/*
Title : 숫자 야구
URL : https://programmers.co.kr/learn/courses/30/lessons/42841

- 경우의 수가 1000개 이하가 나온다면 완전탐색을 이용하는 것이 더 낫다.
 */
package Programmers;

import java.util.*;

public class BruteForce_3 {

	static int solution(int[][] baseball) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				for(int k=1; k<10; k++) {
					if(i != j && j != k && i !=k) queue.add(i*100+j*10+k);
				}
			}
		}

		boolean flag = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int num = queue.remove();
			// strike, ball 여부 확인
			for(int i=0; i<baseball.length && flag; i++) {
				int strike = strike(num, baseball[i][0]);
				int ball = ball(num, baseball[i][0]) - strike;

				if(strike != baseball[i][1] || ball != baseball[i][2]) flag = false;
			}
			if(flag) cnt++;
			flag = true;
		}
		return cnt;
	}

	static int strike(int num, int target) {
		String s1 = String.valueOf(num);
		String s2 = String.valueOf(target);
		int cnt = 0;
		for(int i=0; i<3; i++) {
			cnt = s1.charAt(i) == s2.charAt(i) ? cnt+1 : cnt;
		}
		return cnt;
	}

	static int ball(int num, int target) {
		String s1 = String.valueOf(num);
		String s2 = String.valueOf(target);
		int cnt = 0;
		for(int i=0; i<3; i++) {
			cnt = s1.contains(String.valueOf(s2.charAt(i))) ? cnt+1 : cnt;
 		}
		return cnt;
	}

	public static void main(String[] args) {
		int[][] baseball = {
				{123, 1, 1},
				{356, 1, 0},
				{327, 2, 0},
				{489, 0, 1}
		};
		System.out.println(solution(baseball));
	}
}
