package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackQueue_1_1 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 2;
		int[] truck_weights = {7,4,5,6};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	static int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0; // 소요시간

		Deque<Integer> wait = new ArrayDeque<>();
		Deque<Truck> bridge = new ArrayDeque<>();

		for(int n : truck_weights) wait.add(n);

		int total = 0;
		while(!wait.isEmpty() || !bridge.isEmpty()) {

			time++;

			if(!bridge.isEmpty()) {
				Truck t = bridge.peekFirst();
				if(time - t.len >= bridge_length) {
					total -= t.truck_weight;
					bridge.pollFirst();
				}
			}

			if(!wait.isEmpty()) {
				if(total + wait.peekFirst() <= weight) {
					int tmp = wait.pollFirst();
					total += tmp;
					bridge.addLast(new Truck(tmp, time));
				}
			}
		}

		return time;
	}

	static class Truck {
		int truck_weight;
		int len;

		public Truck(int truck_weight, int len) {
			this.truck_weight = truck_weight;
			this.len = len;
		}
	}

}
