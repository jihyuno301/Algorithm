/*
Title : 단어수학
URL : https://www.acmicpc.net/problem/1339
 */
package BaekJoon.BruteForce;

import java.io.BufferedReader;
		import java.io.IOException;
		import java.io.InputStreamReader;
		import java.util.*;

public class Q1339 {
	static char[] getAlphabets(char[][] words) {
		Set<Character> hashSet = new HashSet<>();
		for(char[] word : words) {
			for(char c : word) hashSet.add(c);
		}
		char[] alphabets = new char[hashSet.size()];
		int idx = 0;
		for(char c : hashSet) {
			alphabets[idx++] = c;
		}
		return alphabets;
	}

	static int sum(char[][] words, char[] alphabets, int[] numbers) {
		System.out.println(Arrays.toString(numbers));
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<alphabets.length; i++) {
			map.put(alphabets[i], numbers[i]);
		}
		for(char[] word : words) {
			int tmp = 0;
			for(char c : word) {
				tmp = tmp*10+map.get(c);
			}
			result += tmp;
		}
		return result;
	}

	static int solution(char[][] words, char[] alphabets, int[] numbers, boolean[] selected, int idx) {
		if(idx >= alphabets.length) return sum(words, alphabets, numbers);
		int max = 0;
		for(int i=0; i<10; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			numbers[idx] = i;
			int tmp = solution(words, alphabets, numbers, selected, idx + 1);
			selected[i] = false;
			if (tmp > max) max = tmp;
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] words = new char[N][];
		for(int i=0; i<N; i++) {
			words[i] = br.readLine().toCharArray();
		}
		char[] alphabets = getAlphabets(words);
		int result = solution(words, alphabets, new int[alphabets.length], new boolean[10], 0);
		System.out.println(result);
	}
}
