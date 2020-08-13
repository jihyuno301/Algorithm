package Programmers.모든문제;

import java.util.HashSet;
import java.util.Set;

public class P2 {
	public static void main(String[] args) {

	}

	static int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		Set<Integer> hashSet = new HashSet<>();
		for(int num : reserve) hashSet.add(num);


		for(int num : lost) {
			// 체육복을 잃어버린 아이가 여벌 옷을 가지고 있는 경우
			if(hashSet.contains(num)) {
				answer += 1;
				hashSet.remove(num); // 빌려줄 수 없으니까
			} else if(hashSet.contains(num-1)) { // 체육복을 잃어버린 아이가 여벌 옷이 없는 경우
				answer += 1;
				hashSet.remove(num-1);
			} else if(hashSet.contains(num+1)) {
				answer += 1;
				hashSet.remove(num+1);
			} else {
				continue;
			}
		}

		return answer;
	}
}
