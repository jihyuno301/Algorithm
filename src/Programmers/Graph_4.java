/*
Title : 여행경로
URL : https://programmers.co.kr/learn/courses/30/lessons/43163

- NullPointerException 해결요함
 */
package Programmers;

import java.util.*;

public class Graph_4 {

	static Map<String, Integer> map;
	static List<Ticket>[] routes;
	static List<String> result;

	static class Ticket implements Comparable<Ticket>  {
		String depart;
		String arrive;

		public Ticket(String depart, String arrive) {
			this.depart = depart;
			this.arrive = arrive;
		}

		@Override
		public int compareTo(Ticket ticket) {
			return this.arrive.compareTo(ticket.arrive);
		}
	}

	static String[] solution(String[][] tickets) {

		routes = new ArrayList[tickets.length];
		result = new ArrayList<>();
		map = new HashMap<>(); // key=공항명, value=인덱스

		for (int i = 0; i < tickets.length; i++) {
			routes[i] = new ArrayList<>();
		}

		int idx = 0;
		for (String[] ticket : tickets) {
			// 해당 항공권의 출발지가 추가되어있지 않은 경우
			if (!map.containsKey(ticket[0])) {
				map.put(ticket[0], idx);
				routes[idx++].add(new Ticket(ticket[0], ticket[1]));
			} else {
				routes[map.get(ticket[0])].add(new Ticket(ticket[0], ticket[1]));
			}
		}

		for(int i=0; i<tickets.length; i++) {
			Collections.sort(routes[i]);
		}

		result.add("ICN");
		dfs(map.get("ICN"));

		String[] ans = new String[result.size()];
		ans = result.toArray(ans);
		return ans;

	}

	static void dfs(int idx) {
		System.out.println("1");
		// 종료조건
		if(routes[idx].size()==0) {
			System.out.println("2");
			return;
		}

		//현재 작업 단계
		while(!routes[idx].isEmpty()) {
			Ticket t = routes[idx].remove(0);
			result.add(t.arrive);
			System.out.println(t.arrive);
			dfs(map.get(t.arrive));

		}

	}

	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "SFO" }, {"ICN", "ATL" }, {"SFO", "ATL" }, {"ATL", "ICN" }, {"ATL", "SFO" }};
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"},{"JFK", "HND"}};
		String[] answer = solution(tickets);
		System.out.println(Arrays.toString(answer));
	}
}
