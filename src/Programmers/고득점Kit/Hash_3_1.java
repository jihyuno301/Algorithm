package Programmers.고득점Kit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hash_3_1 {
	static int solution(String[][] clothes) {
		Map<String, Integer> hashMap = new HashMap<>();
		for(String[] str : clothes) {
			if(hashMap.containsKey(str[1])) {
				hashMap.replace(str[1], hashMap.get(str[1])+1);
			}
			else {
				hashMap.put(str[1], 2);
			}

		}
		int result = 1;
		Set<String> set = hashMap.keySet();
		for(String s : set) {
			result *= hashMap.get(s);
		}
		return result-1;
	}
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		solution(clothes);
	}
}
