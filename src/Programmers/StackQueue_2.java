/*
Title : 다리를 건너는 트럭
URL : https://programmers.co.kr/learn/courses/30/lessons/42583

- 다리를 건너지 않은 '대기큐'와 '건너고 있는 중인 큐'를 구분해서 구현해야 한다.
 */
package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue_2 {
	static class Truck {
		int weight;
		int move;

		public Truck(int weight, int move) {
			this.weight = weight;
			this.move = move;
		}
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> q1 = new LinkedList<>(); // 대기트럭
		Queue<Truck> q2 = new LinkedList<>(); // 다리를 건너는 트럭
		int total = 0; // 제한무게
		int time = 0; // 경과시간

		for(int i : truck_weights) {
			q1.add(new Truck(i,0));
		}

		total += q1.peek().weight;
		q2.add(q1.remove());

		while(!q2.isEmpty()) {
			// 1초당 다리를 건너고 있는 트럭들 거리1씩 이동
			time++;
			for(Truck t : q2) {
				t.move++;
			}

			if(q2.peek().move == bridge_length) {
				total -= q2.remove().weight;
			}

			if(!q1.isEmpty() && total+q1.peek().weight <= weight) {
				total += q1.peek().weight;
				q2.add(q1.remove());
			}
		}
		return time+1;
	}
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};

		int result = solution(bridge_length, weight, truck_weights);
		System.out.println(result);
	}
}
