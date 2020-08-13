package BaekJoon.Collection;


import java.util.*;
import java.util.Queue;

public class Q1966_1 {

	public static class Document {
		int idx;
		int value;

		public Document(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while(T-->0) {

			int n = sc.nextInt(); // 문서의 수
			int location = sc.nextInt(); // 특정 문서의 위치
			int cnt = 0;

			Queue<Document> queue = new LinkedList<>();
			List<Integer> list = new ArrayList<>(); // 중요도 저장

			for(int i=0; i<n; i++) {
				int tmp = sc.nextInt();
				queue.add(new Document(i, tmp));
				list.add(tmp);
			}

			Collections.sort(list);

			while(!queue.isEmpty()) {
				Document document = queue.poll();
				if(list.get(list.size()-1) > document.value) { // 현재 문서 중요도가 떨어지면
					queue.add(document); // 뒤로 보내기
				} else {
					cnt += 1;
					list.remove(list.size()-1); // 마지막 값 제거
					if(document.idx == location) break;
				}
			}
			System.out.println(cnt);
		}
	}
}
