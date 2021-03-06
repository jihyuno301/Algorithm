/*
Title : 기능개발
URL : https://programmers.co.kr/learn/courses/30/lessons/42586
 */
package Programmers.고득점Kit;

import java.util.*;

public class StackQueue_3 {
	static class Function {
		int progresses;
		int speeds;
		int deploy = 0;

		public Function(int progresses, int speeds) {
			this.progresses = progresses;
			this.speeds = speeds;
		}

		int getDeploy() {
			while(progresses < 100) {
				progresses += this.speeds;
				deploy++;
			}
			return deploy;
		}
	}

	static int[] solution(int[] progresses, int[] speeds) {
		Queue<Function> queue = new LinkedList<>();
		List<Integer> arrayList = new ArrayList<>();

		int length = progresses.length;
		for(int i=0; i<length; i++) {
				queue.add(new Function(progresses[i], speeds[i]));
		}

		int cnt = 0;
		while(!queue.isEmpty()) {
			Function function = queue.remove();
			++cnt;
			while(!queue.isEmpty()) {
				if(function.getDeploy() >= queue.peek().getDeploy()) {
					queue.remove();
					++cnt;
				} else break;
			}
			arrayList.add(cnt);
			cnt = 0;
		}

		int[] arr = new int[arrayList.size()];
		for(int i=0; i<arrayList.size(); i++) {
			arr[i] = arrayList.get(i).intValue();
		}
		return arr;
	}


	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};

		int[] result = solution(progresses, speeds);
		System.out.println(Arrays.toString(result));
	}
}
