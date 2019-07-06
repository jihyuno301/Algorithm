package Basic;
/*
 * Title : 평균은 넘겠지
 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 * 입력 : 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 * 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 * 출력 : 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Q4344 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		String[] op = new String[T]; // 출력값
		for(int i=0; i<T; i++) {
			String[] N = br.readLine().split(" ");
			int total = 0;
			for(int j=1; j<N.length; j++) {
				total += Integer.parseInt(N[j]);
			}
			double arg = total/(N.length-1);
			int count = 0;
			for(int z=1; z<N.length; z++) {
				if(arg<Double.parseDouble(N[z])) count++;
			}
			double d = (double)count/(N.length-1)*100;
			op[i] = String.format("%.3f",d);
			
		}
		
		for(int i=0; i<op.length; i++) {
			bw.write(op[i]+"%\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}
