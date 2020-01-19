package BaekJoon.Collection;

import java.util.*;
import java.util.Queue;

public class Q5430 {
	static String translateIntoAC(char[] func, int[] arr) {
		Queue<Character> queue = new LinkedList<>();
		List<Integer> arrayList = new ArrayList<>();

		for(int i=0; i<func.length; i++) {
			queue.add(func[i]);
		}

		if(arr.length == 0) return "error";

		while(!queue.isEmpty()) {
			char c = queue.remove();
			// 숫자 뒤집기
			if( c == 'R') {
				arr = reverseIntArray(arr);
			}
			if( c == 'D') {
				if(arr.length == 0 || arr[0] == 0 ) return "error";
				arr = takeOutFirstInt(arr);
			}
		}

		int i = 0;
		while(arr[i] != 0) arrayList.add(arr[i++]);
		return arrayList.toString();

	}
	static int[] reverseIntArray(int[] arr) {
		int n = arr.length / 2;
		for(int i=0; i<n; i++) {
			int tmp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = tmp;
		}
		return arr;
	}

	static int[] takeOutFirstInt(int[] arr) {
		if(arr.length == 1) {
			arr[0] = 0;
			return arr;
		}
		for(int i=0; i<arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = 0;
		return arr;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();
		scan.nextLine(); // 개행문자 제거
		for(int i=0; i<T; i++) {
			String str = scan.nextLine().trim();
			char[] func = str.toCharArray();
			int N = scan.nextInt(); // 배열의 크기
			int[] arr = new int[N];
			for(int k=0; k<N; k++) {
				arr[k] = scan.nextInt();
			}
			scan.nextLine(); // 개행문자 제거
			String output = translateIntoAC(func, arr);
			System.out.println(output);

 		}
	}
}
