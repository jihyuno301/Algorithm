package BaekJoon.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Q10845_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();

		int T = Integer.parseInt(st.nextToken());

		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
				case "push" :
					queue.add(Integer.parseInt(st.nextToken()));
					break;
				case "front" :
					System.out.println(queue.isEmpty() ? -1 : queue.peek());
					break;
				case "back" :
					System.out.println(queue.isEmpty() ? -1 : back(queue));
					break;
				case "size" :
					System.out.println(queue.size());
					break;
				case "empty" :
					System.out.println(queue.isEmpty() ? 1 : 0 );
					break;
				case "pop" :
					System.out.println(queue.isEmpty() ? -1 : queue.poll());
					break;
				default :
					System.out.println("error");
					return;
			}
		}
	}

	static int back(Queue<Integer> queue) {
		Iterator iterator = queue.iterator();
		List<Integer> list = new ArrayList<>();
		while(iterator.hasNext()) {
			list.add((Integer)iterator.next());
		}
		return list.get(list.size()-1);
	}
}
