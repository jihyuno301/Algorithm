/*
Title : 일곱 난쟁이
URL : https://www.acmicpc.net/problem/2309
Description : 9명의 난쟁이들 중에서 7명의 난쟁이를 뽑아 난쟁이들의 키의 합이  100이 되어야 한다.
*/
package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2309 {

	static int cnt = 0;

	static int sum(List<Integer> list) {
		int result = 0;
		for (int i : list)
			result += i;
		return result;
	}

	static boolean search(int[] A, int index, List<Integer> selected) {
		if (selected.size() == 7) {
			cnt++;
			System.out.println(cnt+" : "+ selected.toString());
			return sum(selected) == 100;
		}
		// 앞에서 두개의 정수를 제거하기 위함
		if (A.length - index > 7 - selected.size()) {
			if (search(A, index + 1, selected)) return true;
		}
		// 두개의 정수를 제거했다면
		selected.add(A[index]);
		if (search(A, index+1, selected)) return true;
		System.out.println("제거:"+selected.remove(selected.size() - 1));
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[9];
		for (int i = 0; i < 9; ++i)
			A[i] = Integer.parseInt(reader.readLine());
		Arrays.sort(A);
		ArrayList<Integer> selected = new ArrayList<Integer>();
		search(A, 0, selected);
		for (int i : selected)
			System.out.println(i);
	}
}
