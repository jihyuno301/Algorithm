package AlgorithmCourse;

import java.util.Arrays;

public class Combination1 {
	static void dfs(int[] numbers, boolean[] selected, int[] combination,  int idx) {
		if(idx >= combination.length) {
			System.out.println(Arrays.toString(combination));
			return;
		}
		for(int i=0; i<numbers.length; i++) { // 모든 수
			if(selected[i]) continue;
			selected[i] = true;
			combination[idx] = numbers[i];
			dfs(numbers, selected, combination, idx+1);
			selected[i] = false;
		}
	}
	public static void main(String[] args) {
		int[] numbers = {0, 1, 2, 3, 4};
		dfs(numbers, new boolean[numbers.length], new int[3], 0);
	}
}
