package BaekJoon.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10799_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		String str = br.readLine();


		char pre = ' ';
		int answer = 0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);

			switch(c) {
				case '(' :
					stack.push(c);
					break;
				case ')' :
					if(!stack.isEmpty()) {
						stack.pop();
						if(pre == '(') { //레이저
							answer += stack.size();
						} else answer += 1;
					}
					break;
			}

			pre = c;
		}

		System.out.println(answer);
	}
}
