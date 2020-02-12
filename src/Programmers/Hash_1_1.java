package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Hash_1_1 {

	static String solution(String[] participant, String[] completion) {
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		for(String s : participant) {
			if(hashMap.containsKey(s)) {
				hashMap.replace(s,hashMap.get(s)+1);
			}
			else {hashMap.put(s,1);}
		}

		for(String s : completion) {
			if(hashMap.containsKey(s)) {
				hashMap.replace(s, hashMap.get(s)-1);
			}
		}

		for(String s : participant) {
			if(hashMap.get(s) == 1) return s;
		}

		return "no one";
	}
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant, completion));
	}
}
