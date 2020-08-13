package Programmers.고득점Kit;

public class Hash_2_1 {
	static boolean solution(String[] phone_book) {
		for(String pivot : phone_book) {
			for(String s : phone_book) {
				if(s.equals(pivot)) continue;
				if(s.startsWith(pivot)) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
}
