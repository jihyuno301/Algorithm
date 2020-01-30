/*
Title : 모의고사
URL : https://programmers.co.kr/learn/courses/30/lessons/42840
 */
package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce_1 {
	static int[] solution(int[] answers) {
		List<Integer> arrayList = new ArrayList<>();
		int[][] arr = {
				{1,2,3,4,5},
				{2,1,2,3,2,4,2,5},
				{3,3,1,1,2,2,4,4,5,5}
		};
		int[] students = new int[3];
		for(int i=0; i<answers.length; i++) {
			if(answers[i] == arr[0][i%5]) students[0]++;
			if(answers[i] == arr[1][i%8]) students[1]++;
			if(answers[i] == arr[2][i%10]) students[2]++;
		}

		int max = students[0];
		for(int i=1; i<3; i++) {
			if(students[i] > max) max = students[i];
		}

		for(int i=0; i<3; i++) {
			if(students[i] == max) arrayList.add(i);
		}

		int[] result = new int[arrayList.size()];
		for(int i=0; i<arrayList.size(); i++) result[i] = arrayList.get(i)+1;
		return result;
	}
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		System.out.println(Arrays.toString(solution(answers)));

	}
}
