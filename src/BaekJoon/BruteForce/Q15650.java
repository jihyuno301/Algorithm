/*
Title : N과 M (2)
URL : https://www.acmicpc.net/problem/15650

 */
package BaekJoon.BruteForce;

import java.util.*;

public class Q15650 {

	static int N, M;

	static void solution(boolean[] visited, List<Integer> arrayList, Set<List<Integer>> hashSet) {
		if(arrayList.size() == M) {
			Collections.sort(arrayList);
			if(hashSet.contains(arrayList)) return;
			hashSet.add(arrayList);
			StringBuilder sb = new StringBuilder();
			for(int i : arrayList) {
				sb.append(i+" ");
			}
			System.out.println(sb.toString());
		}

		for(int i=1; i<=N; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				arrayList.add(i);
				solution(visited, arrayList, hashSet);
				visited[i] = false;
				// 정렬된 arrayList에서 인덱스가 아니라 i값을 지우기 위해서 int형 값을
				// Integer형으로 변환
				arrayList.remove((Integer)i);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		boolean[] visited = new boolean[N+1];
		List<Integer> arrayList = new ArrayList<>();
		// HashSet 제네릭 타입에 List도 가능!
		Set<List<Integer>> hashSet = new HashSet<>();
		solution(visited, arrayList, hashSet);

	}
}
