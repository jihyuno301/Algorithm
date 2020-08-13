/*
Title : 프린터
URL : https://programmers.co.kr/learn/courses/30/lessons/42587
 */
package Programmers.고득점Kit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class StackQueue_4 {
	static class Document {
		int document;
		int index;

		public Document(int document, int index) {
			this.document = document;
			this.index = index;
		}
	}
	public static void main(String[] args) {
		int[] priorities = {2,1,3,2};
		int location = 2;

		Deque<Document> deque = new ArrayDeque<>();
		ArrayList<Document> arrayList = new ArrayList<>();

		for(int i=0; i<priorities.length; i++) {
			deque.add(new Document(priorities[i], i));
		}

		while(!deque.isEmpty()) {
			Document document = deque.removeFirst();
			int current_pri = document.document;
			Iterator<Document> iterator = deque.iterator();
			while(iterator.hasNext()) {
				Document d = iterator.next();
				if(current_pri < d.document) {
					deque.addLast(document);
					break;
				}
			}
			if(!iterator.hasNext()) arrayList.add(document);
		}

		int cnt = 0;
		for(Document d: arrayList) {
			cnt++;
			if(d.index == location) break;
		}
		System.out.println(cnt);
	}
}
