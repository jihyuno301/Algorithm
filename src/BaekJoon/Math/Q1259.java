/*
Title : 팰린드롬수
URL : https://www.acmicpc.net/problem/1259
 */
package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();

			if(str.equals("0")) return;

			char[] arr = str.toCharArray();
			int start;
			int end = arr.length-1;

			for(start=0; start<arr.length/2; start++, end--) {
				if(arr[start] != arr[end]) break;
			}

			if(start == arr.length/2) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
