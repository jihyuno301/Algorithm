package PrimeNumber;
/*
 * Title : 소수 찾기
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 입력 : 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * 출력 : 주어진 수들 중 소수의 개수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q1978 {

	public static void main(String[] args) throws IOException {
		//소수 : 1과 자기 자신만으로 나누어 떨어지는 1보다 큰 양의 정수
		//나누어 떨어진다 : 몫이 항상 자연수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		int cnt = 0; 
		int a;
		while(st.hasMoreTokens()==true) {
			int n = Integer.parseInt(st.nextToken());
			a = 0;
			for(int i=1; i<=n; i++) {
				if(n%i==0) a++;
			}
			if(a==2) cnt++;
		}
		
		System.out.println(cnt);	
		

	}

}
