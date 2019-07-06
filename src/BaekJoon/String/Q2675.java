package String;
/*
 * Title : 문자열 반복
 * 문자열S를 입력받은 후에, 각 문자를 R번 반복해  새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
 * 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. 
 * S에는 QR Code "alphanumeric"문자만 들어있다.
 * 입력 : 첫째 줄에 테스트 케이스의 개수T가 주어진다. 각 테스트 케이스는 반복횟수 R, 문자열 S가 공백으로 구분되어
 * 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
 * 출력 : 각 테스트 케이스에 대해 P를 출력한다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int re = Integer.parseInt(st.nextToken());
			char[] str = st.nextToken().toCharArray();
			for(int j=0; j<str.length; j++) {
				for(int z=0; z<re; z++) {
					sb.append(str[j]);
				}
			}
			sb.append("\n");
			
		}
		System.out.print(sb.toString());
	}
}
