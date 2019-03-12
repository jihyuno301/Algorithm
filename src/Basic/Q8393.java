package Basic;
/*
 * Title : 합
 * n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
 * 출력 : 1부터 n까지 합을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8393 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num = Integer.parseInt(str);
		
		System.out.println(add(num));

	}
	
	public static int add(int num) {
		if(num<=1) return 1;
		else return num+add(num-1);
	}

}
