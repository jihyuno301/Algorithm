package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue_2 {
	static class Truck {
		int weight;
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer>  queue = new LinkedList<>();
		int weight_total = 0; // 트럭들의 총무게
		int length_total = 0; // 트럭의 이동거리
		int result = 0; // 경과 시간

		for(int i : truck_weights) queue.add(i);

		while(!queue.isEmpty()) {
			int truck_weight = queue.peek();
			weight_total += truck_weight;
			++length_total;
			if(weight_total < weight) {

			} else {

			}
		}
	}
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};

		int result = solution(bridge_length, weight, truck_weights);
		System.out.println(result);
	}
}
