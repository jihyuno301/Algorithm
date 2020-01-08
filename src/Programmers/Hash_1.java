/*
Title : 완주하지 못한 선수(해시)
문제 : 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 */
package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Hash_1 {

	public String solution(String[] participant, String[] completion) {
		// 동명이인이 있을 수 있기 때문에 Set을 사용할 수 없다.
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		for(String s : participant) {
			if(hashMap.containsKey(s)) {
				int temp = hashMap.get(s);
				hashMap.put(s,temp+1);
			} else {
				hashMap.put(s,1);
			}
		}

		for(String s : completion) {
			if(hashMap.containsKey(s)) {
				int temp = hashMap.get(s);
				hashMap.put(s,temp-1);
			}
		}

		for(String s : participant) {
			if(hashMap.get(s) != 0) return s;
		}
		return "마라톤에 참여한 모든 선수가 완주하였습니다";
	}
}
