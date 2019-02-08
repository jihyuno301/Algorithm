package io;
/*
 * Title : 별찍기-3
 * 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제
 * 입력 : 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
 * 출력 : 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
 */
import java.util.Scanner;
public class Q2440 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for(int i=num; i>0; i--) {
			String str = new String(new char[i]).replace("\0","*");
			System.out.println(str);
		}
	}
}
