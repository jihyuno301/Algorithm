/*
Title : 가장 큰 수
URL : https://programmers.co.kr/learn/courses/30/lessons/42746

- 선택조합을 이용하여 문제를 풀려고 하였지만 solution 메소드에 매개변수가 정해져 있어
해결 할 수 없었다.
- Comparator 인터페이스를 이용하여 내림차순으로 쉽게 풀 수 있었다.
 */
package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Sort_2 {
	static String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		String[] str = new String[numbers.length];

		for(int i=0; i<numbers.length; i++) {
			str[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return (str2+str1).compareTo(str1+str2);
			}
		});

		// 0으로만 구성되어 있는 경우
		if(str[0].equals("0")) return "0";

		for(String s : str) sb.append(s);

		return sb.toString();
	}

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));
	}
}
