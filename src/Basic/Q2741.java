package Basic;


/*
 * Title : N찍기
 * 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.
 * 출력 : 첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
 * 
 */
import java.util.Scanner;

public class Q2741 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); 
		
		int num;
		System.out.print("입력:");
		num = input.nextInt();
		
		for(int i=1; i<=num; i++) {
			System.out.println(i);
		}
		
	}

}
