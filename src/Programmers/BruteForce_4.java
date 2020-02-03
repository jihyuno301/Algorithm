/*
Title : 카펫
URL : https://programmers.co.kr/learn/courses/30/lessons/42842
 */
package Programmers;

import java.util.Arrays;

public class BruteForce_4 {
	static int[] solution(int brown, int red) {
		int[] result = new int[2];
		for(int i=3; i<Integer.MAX_VALUE; i++) { // 가로
			for(int j=3; j<=i; j++) { // 세로
				int red_cnt = (i-2)*(j-2);
				int brown_cnt = (i*j) - red_cnt;
				if(red_cnt == red && brown_cnt == brown) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] comb = {
				{10, 2},
				{8, 1},
				{24, 24}
		};
		for(int[] a : comb) {
			System.out.println(Arrays.toString(solution(a[0], a[1])));
		}
	}
}
