/*
Title : 소수 찾기
URL : https://programmers.co.kr/learn/courses/30/lessons/42839
 */
package Programmers;

import java.util.*;

public class BruteForce_2 {

	static int[] number;
	static Set<Integer> hashSet = new HashSet<>();
	static int cnt = 0;

	static void combination(boolean[] selected, List<Integer> arrayList) {
		if(arrayList.size() == selected.length) {
			return;
		}
		for(int i=0; i<number.length; i++) {
			if(selected[i] == false) {
				selected[i] = true;
				arrayList.add(number[i]);
				String s = "";
				for(int k : arrayList) {
					s += String.valueOf(k);
				}

				if(isPrimeNumber(Integer.parseInt(s))) {
					if(!hashSet.contains(Integer.parseInt(s))) {
						hashSet.add(Integer.parseInt(s));
						cnt++;
					}
				}
				combination(selected, arrayList);
				selected[i] = false;
				arrayList.remove(arrayList.size()-1);
			}
		}
	}

	static boolean isPrimeNumber(int n) {
		if(n==0 || n==1) return false;
		for(int i=2; i<n; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
	static int solution(String numbers) {
		number = new int[numbers.length()];
		for(int i=0; i<numbers.length(); i++) {
			// char -> int 형 변환
			number[i] = numbers.charAt(i)-'0';
		}
		boolean[] selected = new boolean[number.length];
		List<Integer> arrayList = new ArrayList<>();
		combination(selected, arrayList);
		return cnt;

	}
	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));
	}
}
