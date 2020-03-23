package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1339_1 {

	static char[] getAlphabets(char[][] words) {
		Set<Character> hashSet = new HashSet<>();
		char[] alphabets;
		for(char[] word : words) {
			for(char c : word) {
				if(hashSet.contains(c)) continue;
				hashSet.add(c);
			}
		}

		alphabets = new char[hashSet.size()];
		int idx = 0;
		for(char c : hashSet) {
			alphabets[idx++] = c;
		}

		return alphabets;
	}

	static int dfs(char[][] words, char[] alphabets, int[] numbers, boolean[] visited, int idx) {
		if(idx >= alphabets.length) {
			return sum(words, alphabets, numbers);
		}
		int max = 0;
		for(int i=0; i<10; i++) {
			if(visited[i]) continue; // 이미 i값이 사용된 경우 pass
			numbers[idx] = i;
			visited[i] = true;
			int tmp = dfs(words, alphabets, numbers, visited, idx+1);
			if(tmp > max) max = tmp;
			visited[i] = false;
		}
		return max;
	}

	static int sum(char[][] words, char[] alphabets, int[] numbers) {
		Map<Character, Integer> hashMap = new HashMap<>();
		for(int i=0; i<alphabets.length; i++) {
			hashMap.put(alphabets[i], numbers[i]);
		}

		int total = 0;
		for(char[] word : words) {
			int tmp = 0;
			for(char c : word) {
				tmp = tmp*10+hashMap.get(c);
			}
			total += tmp;
		}
		return total;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] words = new char[N][];
		for(int i=0; i<N; i++) {
			words[i] = br.readLine().toCharArray();
		}
		char[] alphabets = getAlphabets(words);
		int[] numbers = new int[alphabets.length]; //각 알파벳마다 부연한 값
		boolean[] visited = new boolean[10];
		int result = dfs(words, alphabets, numbers, visited, 0);
		System.out.println(result);
	}
}
