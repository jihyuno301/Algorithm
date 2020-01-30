/*
Title : H-Index
URL ; https://programmers.co.kr/learn/courses/30/lessons/42747
 */
package Programmers;

import java.util.Arrays;

public class Sort_3 {
	static int solution(int[] citations) {
		Arrays.sort(citations);
		int result = 0;
		for(int i=0; i<citations.length; i++) {
			int pivot = citations[i];
			int n = citations.length - i;
			if(n <= pivot) {
				result = n;
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));

	}
}
