package Test;

import java.io.*;
import java.util.*;

public class Q2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, List<Integer>> hashMap = new HashMap<>(); // key=팀명,[0]=승수, [1]=세트득실

		for(int i=0; i<N*(N-1); i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String t1 = st.nextToken();
			int w1 = Integer.parseInt(st.nextToken());
			String t2 = st.nextToken();
			int w2 = Integer.parseInt(st.nextToken());

			// t1 팀명이 있는 경우
			if(hashMap.containsKey(t1)) {
				if(w1 > w2) {
					int tmp = hashMap.get(t1).get(0);
					hashMap.get(t1).set(0, tmp+1);
				}

				int n = hashMap.get(t1).get(1);
				hashMap.get(t1).set(1, n+(w1-w2));
			}

			// t2 팀명이 있는 경우
			if(hashMap.containsKey(t2)) {
				if(w2 > w1) {
					int tmp = hashMap.get(t2).get(0);
					hashMap.get(t2).set(0, tmp+1);
				}

				int n = hashMap.get(t2).get(1);
				hashMap.get(t2).set(1, n+(w2-w1));
			}

			// t1 팀명이 없는 경우
			if(!hashMap.containsKey(t1)) {
				hashMap.put(t1, new ArrayList<>());

				ArrayList<Integer> arrayList = new ArrayList<>();
				if (w1 > w2) arrayList.add(1);  // 승수
				else arrayList.add(0);

				arrayList.add(w1 - w2); // 세트득실
				hashMap.put(t1, arrayList);
			}

			// t2 팀명이 없는 경우
			if(!hashMap.containsKey(t2)) {
				hashMap.put(t2, new ArrayList<>());

				ArrayList<Integer> arrayList2 = new ArrayList<>();
				if (w2 > w1) arrayList2.add(1);  // 승수
				else arrayList2.add(0);

				arrayList2.add(w2 - w1); // 세트득실
				hashMap.put(t2, arrayList2);
			}

		}

//		Iterator<String> keys = hashMap.keySet().iterator();
//		while(keys.hasNext()) {
//			String key = keys.next();
//			System.out.println(String.format("키 : %s, 값[0] : %d, 값[1] : %d", key, hashMap.get(key).get(0), hashMap.get(key).get(1)));
//		}

		Iterator<String> it = sortByValue(hashMap).iterator();
		while(it.hasNext()) {
			String key = it.next();
//			System.out.println(String.format("키 : %s, 값[0] : %d, 값[1] : %d", key, hashMap.get(key).get(0), hashMap.get(key).get(1)));
			System.out.println(key+" "+hashMap.get(key).get(0)+" "+ hashMap.get(key).get(1));
		}
	}

	public static List sortByValue(final Map map) {
		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator() {

			public int compare(Object a1, Object a2) {
				// 승수 비교
				List<Integer> n1 = (List<Integer>)map.get(a1);
				List<Integer> n2 = (List<Integer>)map.get(a2);

				int r = n2.get(0) - n1.get(0);
				if(r != 0) return r; // 승수가 같지 않다면

				// 세트득실 비교
				return n2.get(1) - n1.get(1);

			}
		});

		return list;
	}
}
