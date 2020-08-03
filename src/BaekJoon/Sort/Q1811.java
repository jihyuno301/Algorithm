/*
Title : 단어 정렬
URL : https://www.acmicpc.net/problem/1181
 */
package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Q1811 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] arr = new String[T];

		for(int i=0; i<T; i++) {
			arr[i] = br.readLine();
		}

		Arrays.sort(arr, new Comparator<String>(){
			@Override
			public int compare(String str1, String str2) {
				if(str1.length() != str2.length()) return str1.length() - str2.length();
				return str1.compareTo(str2); // 오름차순
			}
		});


		Set<String> hashSet = new HashSet<>();
		for(String str : arr) {
			if(hashSet.contains(str)) continue;
			hashSet.add(str);
			System.out.println(str);
		}
	}

}
