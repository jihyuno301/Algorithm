package Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Q4 {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};

		System.out.println(solution(board, moves));
	}

	static int solution(int[][] board, int[] moves) {

		Deque<Integer> arrayDeque = new ArrayDeque<>();
		int answer = 0;
		int r = board.length;

		for(int move : moves) {
			move = move -1;


			for(int i=0; i<r; i++) {
				if(board[i][move] != 0) {
					int n = board[i][move];

					if(!arrayDeque.isEmpty() && arrayDeque.peek() == n) {
						arrayDeque.pop();
						answer += 2;
					} else {
						arrayDeque.push(n);
					}

					board[i][move] = 0;
					break;
				}
			}
		}

		return answer;
	}

}
