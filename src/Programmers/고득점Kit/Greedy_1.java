/*
Title : 체육복
URL : https://programmers.co.kr/learn/courses/30/lessons/42862
 */
package Programmers.고득점Kit;

public class Greedy_1 {
	static int solution(int n, int[] lost, int[] reserve) {
		int student_cnt = n-lost.length; // 체육수업을 들을 수 있는 학생 수

		// 체육복을 잃어버린 아이가 여벌 옷을 가지고 있는 경우
		for(int i=0; i<reserve.length; i++) {
			for(int k=0; k<lost.length; k++) {
				if(lost[k] == 0 && reserve[i] == 0) continue;
				if(reserve[i] == lost[k]) {
					reserve[i] = 0;
					lost[k] = 0;
					student_cnt++;
				}
			}
		}

		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(lost[i] == 0 || reserve[j] == 0) continue;
				if(Math.abs(lost[i]-reserve[j])==1) {
					reserve[j] = 0;
					student_cnt++;
					break;
				}
			}
		}
		return student_cnt;
	}
	public static void main(String[] args) {
		int n = 3;
		int[] lost = {3};
		int[] reserve = {1};
		System.out.println(solution(n, lost, reserve));
	}
}
