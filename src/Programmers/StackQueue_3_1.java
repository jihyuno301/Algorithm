package Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StackQueue_3_1 {
	public static void main(String[] args) {
		int[] priorities = {1,1,9,9,1,1};
		int location = 0;
		System.out.println(solution(priorities,location));
	}

	static int solution(int[] priorities, int location) {
		Deque<Document> documents = new ArrayDeque<>();
		List<Integer> bigger = new ArrayList<>();

		int rqDocument = priorities[location];
		for(int i=0; i<priorities.length; i++) {
			documents.addLast(new Document(priorities[i],i));
			if(priorities[i] > rqDocument) bigger.add(priorities[i]);
		}

		int cnt = 0;
		while(!documents.isEmpty()) {
			Document document = documents.removeFirst();
			if(bigger.size()>0 && bigger.contains(document.priority)) {
				bigger.remove((Integer)document.priority);
				cnt++;
				continue;
			}

			if(bigger.size()==0) {
				if(document.idx == location) {
					cnt++;
					break;
				}
				documents.addLast(document);
			}
		}

		return cnt;
	}

	static class Document {
		int priority;
		int idx;

		public Document(int priority, int idx) {
			this.priority = priority;
			this.idx = idx;
		}
	}

}
