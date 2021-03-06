/*
 * Title : 분수찾기
 * 무한히 큰 배열에 다음과 같이 분수들이 적혀있다. 이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로
 * 1번, 2번, 3번, 4번, 5번, … 분수라고 하자. X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 * 출력 : 첫째 줄에 분수를 출력한다.
 */
package FindRules;

import java.util.Scanner;

public class Q1193 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt(); 
		
		int pre_sum = 0;
		int sum = 0;
		int layer=1; //층
		while(true) {
			pre_sum = sum;
			sum += layer;
			if(N<=sum) break;
			layer++;
		}
		
		int x = 0; //분자 
		int y = 0; //분모
		int cnt;
		if(layer%2==1) {
			cnt = N-pre_sum;
			for(int i=0; i<cnt; i++) {
				x = layer--;
				y++;
			}
		}
		
		else  {
			cnt = N-pre_sum;
			for(int i=0; i<cnt; i++) {
				x++;
				y = layer--;
			}
		}
		
		System.out.println(x+"/"+y);

	}

}
