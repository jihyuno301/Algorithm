package BaekJoon.BruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q15649 {

	static int N, M;

	static void progression(boolean[] selected, List<Integer> arrayList) {
		if(arrayList.size() == M) {
			StringBuilder sb= new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(arrayList.get(i)+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				arrayList.add(i);
				progression(selected, arrayList);
				selected[i] = false;
				arrayList.remove(arrayList.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		boolean[] selected = new boolean[N+1];
		ArrayList<Integer> arrayList = new ArrayList<>();
		progression(selected, arrayList);
	}
}
