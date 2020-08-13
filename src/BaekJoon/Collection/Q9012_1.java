package BaekJoon.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q9012_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for(int i=0; i<T; i++) {
			Stack<Character> stack = new Stack<>();
			String ps = br.readLine();
			int len;
			for(len=0; len<ps.length(); len++) {
				char c = ps.charAt(len);
				if(c == '(') stack.push(c);
				if(c == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
					else { // 스택이 비어있는 경우 또는 잘못된 괄호인 경우
						break;
					}
				}
				// 문자는 그냥 패스
			}

			if(len==ps.length() && stack.size() == 0) { System.out.println("YES"); }
			else System.out.println("NO"); // len != ps.length() || stack.size() > 0 인 경우
		}
	}
}
