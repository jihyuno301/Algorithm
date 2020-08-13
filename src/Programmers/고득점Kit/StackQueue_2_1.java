package Programmers.고득점Kit;

import java.util.Arrays;
import java.util.Stack;

public class StackQueue_2_1 {
	public static void main(String[] args) {
		int[] heights = {6,9,5,7,4};
		System.out.println(Arrays.toString(solution(heights)));
	}

	static int[] solution(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[heights.length];

		for(int n : heights) stack.push(n);

		int sender, receiver;
		for(int i=heights.length-1; i>=0; i--) {
			sender = stack.pop();

			int cntNum = 0;
			while(!stack.isEmpty()) {
				receiver = stack.pop();
				cntNum++;
				if(receiver > sender) {
					ans[i] = i - cntNum + 1;
					break;
				}
			}

			for(int k=i-cntNum; k<i; k++) {
				stack.push(heights[k]);
			}
		}

		return ans;
	}
}
