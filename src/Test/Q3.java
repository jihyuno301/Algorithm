///*
//현대카드 SE 인턴십 코딩테스트 문제
// */
//package Test;
//
//import java.util.Arrays;
//
//public class Q3 {
//	public static void main(String[] args) {
//		String[] purchase = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
//		System.out.println(Arrays.toString(solution(purchase)));
//		// substring(int beginIdx, int endIdx) : 마지막 문자 인덱스 +1 잊지말기!
//		// 큰따옴표"" 출력 => 출력하고자 하는 문자 앞에 \를 입력한다.
//	}
//
//	static int[] solution (String[] purchase){
//		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		int[] day = new int[366];
//		int[][] document = new int[purchase.length][3]; // 정확한 배열 크기를 정해놓지 않으면 NullPointerException 발생
//
//		for(int i=0; i<purchase.length; i++) {
//			document[i][0] = Integer.parseInt(purchase[i].substring(5,7)); // 월
//			document[i][1] = Integer.parseInt(purchase[i].substring(8,10)); // 일
//			document[i][2] = Integer.parseInt(purchase[i].substring(11)); // 금액
//
//
//		for(int[] arr : document) {
//			if(arr[1]+29 <= month[arr[0]]) {
//
//			}
//		}
//
//		return month;
//	}
//}
