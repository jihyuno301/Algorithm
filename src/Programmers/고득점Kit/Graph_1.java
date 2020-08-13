/*
Title : 타겟 넘버
URL : https://programmers.co.kr/learn/courses/30/lessons/43165
 */
package Programmers.고득점Kit;

public class Graph_1 {

	static int dfs(int[] numbers, int target, int index, int sum) {
		if(index == numbers.length) {
			return sum==target ? 1 : 0;
		}

		return dfs(numbers, target, index+1, sum+numbers[index] )+
				dfs(numbers, target, index+1, sum-numbers[index]);

	}
	static int solution(int[] numbers, int target) {
		int ans = dfs(numbers, target, 0, 0);
		return ans;
	}

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
}
