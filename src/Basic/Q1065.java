package Basic;
/*
 * Title : 한수
 * 어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은  연속된 두 개의 수의 차이가
 * 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
 * 출력 : 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Q1065 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		bw.write(hansoo(N)+"\n");
		bw.flush();
		bw.close();
		
	}
	
	public static int hansoo(int N) {
		int count = 0;
		if(N<100) { //한두자리수는 한수
			count = N;
			return count;
		}
		//100이상인 경우
		count += 99; //1부터99까지
		for(int i=100; i<=N; i++) {
			int d=0, temp;
			int bef=0, now=0;
			int subCount=0;
			int r = i;
			while(r!=0) {
				now = r%10;
				if(subCount==0) {
					bef = now;
					subCount++;
					r = r/10;
				}
				else if(subCount==1) {
					d = bef-now; //공차 구하기
					bef = now;
					subCount++;
					r = r/10;
				}
				else {
					temp = bef-now;
					if(d != temp) break;
					bef = now;
					r = r/10;
					//더이상 subCount할 필요x
				}
			}
			if(r==0) count++;
		}
		return count;
	}
	
}
