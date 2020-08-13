/*
Title : 위장
문제 : 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

종류	이름
얼굴	동그란 안경, 검정 선글라스
상의	파란색 티셔츠
하의	청바지
겉옷	긴 코트

스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

주의할 점 : 모든 경우의 수를 int형으로 반환한다.
 */
package Programmers.고득점Kit;

import java.util.HashMap;
import java.util.Map;

public class Hash_3 {
	public int solution(String[][] clothes) {
		Map<String, Integer> hashMap = new HashMap<>();
		for(int i=0; i<clothes.length; i++) {
			// 해당 카테고리가 이미 있다면
			if(hashMap.containsKey(clothes[i][1])) {
				int num = hashMap.get(clothes[i][1]);
				hashMap.put(clothes[i][1], hashMap.get(clothes[i][1])+1);
			}
			// 해당 카테고리가 없다면
			// 아무것도 선택하지 않은 경우를 포함하여야 하기에 +1을 해야한다.
			// else를 하지않아서 오류발생
			else {
				hashMap.put(clothes[i][1], 2);
			}
		}
		int result = 1;
		// HashMap은 for each를 사용할 수 없다.
        /*
        for(Map.Entry<String,Integer> me : hashMap.entrySet()) {
            result *= me.getValue();
        }
        */
		for(String key : hashMap.keySet()) {
			result *= hashMap.get(key);
		}
		return result-1; // 아무것도 고르지 않은 경우

	}
}
