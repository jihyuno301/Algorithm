 package io;
/*
 * Title : 평균
 * 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에
 * 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
 * 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
 * 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
 * 출력 : 첫째 줄에 새로운 평균을 출력한다. 정답과의 절대/상대 오차는 10-2까지 허용한다.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); //과목수
		String[] str = br.readLine().split(" "); //과목점수
		double[] arr = new double[N]; //조작점수
		double total=0;
		int max = Integer.parseInt(str[0]);
		for(int i=1; i<N; i++) {
			int temp = Integer.parseInt(str[i]);
			if(max<temp) {
				max = temp;
			}
		}
		for(int i=0; i<N; i++) { //조작점수 계산
			int temp = Integer.parseInt(str[i]);
			arr[i] = (double)temp/max*100;
			total += arr[i];
		}
		bw.write(total/N+"\n");
		bw.flush();
		bw.close();
		
		
	}

}
