package Test;

import java.io.*;
class Q1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] pwd = input.toCharArray();
		boolean[] isChecked = new boolean[4]; // 숫자, 소문자, 대문자, 특수문자 순
		int cnt = 0;

		if(pwd.length >= 10 ) ++cnt;
		for(char c : pwd) {
			// 숫자 : 48~57
			if(c>=48 && c<=57) {
				if(!isChecked[0]) {
					isChecked[0] = true;
					++cnt;
				}
			}

			// 소문자 : 97~122
			else if(c>=97 && c<=122) {
				if(!isChecked[1]) {
					isChecked[1] =true;
					++cnt;
				}
			}

			// 대문자 : 65~90
			else if(c>=65 && c<=90) {
				if(!isChecked[2]) {
					isChecked[2] =true;
					++cnt;
				}
			}

			// 특수문자
			else {
				if(!isChecked[3]) {
					isChecked[3] =true;
					++cnt;
				}
			}
		}

		System.out.println("LEVEL"+cnt);
	}
}