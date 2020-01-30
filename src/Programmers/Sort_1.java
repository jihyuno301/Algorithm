package Programmers;

import java.util.Arrays;

public class Sort_1 {
	static int[] solution(int[] array, int[][] commands) {
		int[] result = new int[commands.length];
		int cnt = 0;
		for(int[] command : commands) {
			int[] tmp = new int[command[1]-command[0]+1];
			int t = 0;
			for(int i=command[0]-1; i<=command[1]-1; i++) {
				tmp[t++] = array[i];
			}
			Arrays.sort(tmp);
			result[cnt++] = tmp[command[2]-1];
		}
		return result;
	}
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] result = solution(array, commands);
		System.out.println(Arrays.toString(result));
	}
}
