/*
Title : 일곱 난쟁이
URL : https://www.acmicpc.net/problem/2309
Description : 9명의 난쟁이들 중에서 7명의 난쟁이를 뽑아 난쟁이들의 키의 합이  100이 되어야 한다.
*/
package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];

		for(int i=0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}

		findRealDwarf(dwarf);
	}

	public static void findRealDwarf(int[] dwarf) {
		int[] realDwarf = new int[7];
		int total = 0;
		int idx = 0;

		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				for(int k=0; k<9; k++) {
					if(k==i || k==j) continue;
					System.out.println("realDwarf :"+dwarf[k]);
					realDwarf[idx++] = dwarf[k];
					total += dwarf[k];
				}

				if(total == 100) {
					Arrays.sort(realDwarf);
					for(int one : realDwarf) System.out.println(one);
				}
			}
		}
	}
}
