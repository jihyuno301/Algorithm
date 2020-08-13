package Programmers.고득점Kit;

import java.util.Arrays;

public class StackQueue_6 {
	static int[] solution(int[] prices) {
		int[] result = new int[prices.length];
		for(int i=0; i<prices.length-1; i++) {
			int pivot = prices[i];
			int cnt = 0;
			for (int j = i + 1; j < prices.length; j++) {
				if (pivot <= prices[j]) cnt++;
				else {
					cnt++;
					break;
				}
			}
			result[i] = cnt;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] result = solution(prices);
		System.out.println(Arrays.toString(result));
	}
}
