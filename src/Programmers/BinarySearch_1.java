package Programmers;

import java.util.Arrays;

public class BinarySearch_1 {
	public static void main(String[] args) {
		int[] budgets = {120, 110, 140, 150};
		int M = 485;

		System.out.println(solution(budgets, M));
	}

	static int solution(int[] budgets, int M) {

		int answer = 0;
		int left = 0;
		int right;
		int mid = 0;

		Arrays.sort(budgets);
		right = budgets[budgets.length-1];

		while(left <= right) {
			long sum = 0;
			mid = (left+right)/2;
			System.out.println("mid :" + mid);
			for(int budget : budgets) {
				if(budget >= mid) sum += mid;
				else sum += budget;
			}

			if(sum > M) right = mid-1;
			else {
				answer = mid;
				left = mid+1;
			}
		}

		return answer;
	}
}
