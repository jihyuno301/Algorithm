/*
Title : 크레인 인형뽑기게임(2019 카카오 개발자 겨울 인턴십)
URL : https://programmers.co.kr/learn/courses/30/lessons/64061

- 각 열마다 스택을 만들 수 있는 방법은 없음.
- 열을 고정시키고 행 idx를 이용
- 스택 문제
 */
package Programmers.모든문제;

import java.util.Stack;

public class P1 {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));

	}

	static int solution(int[][] board, int[] moves) {

		Stack<Integer> stack = new Stack<>();
		int result = 0;

		for(int move : moves) {
			int col = move-1;
			for(int i=0; i<board.length; i++) {
				int val = board[i][col];
				if(val != 0) {
					if(!stack.isEmpty() && stack.peek() == val) {
						result += 2;
						stack.pop();
					} else {
						stack.push(val);
					}
					board[i][col] = 0;
					break;
				}

			}
		}

		return result;
	}
}
