/*
Title : 퍼즐
URL : https://www.acmicpc.net/problem/1525
 */
package BaekJoon.Graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1, -1};
		int number = 0;
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 0) tmp = 9;
				number = number*10+tmp;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		Map<Integer,Integer> hashMap = new HashMap<>();

		queue.add(number);
		hashMap.put(number,0);

		while(!queue.isEmpty()) {
			int nowNum = queue.remove();
			String now = String.valueOf(nowNum);
			int nine = now.indexOf('9');
			int x = nine/3;
			int y = nine%3;

			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if((nx>=0 && nx<3) && (ny>=0 && ny<3)) {
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(x*3+y);
					next.setCharAt(x*3+y, (char)next.charAt(nx*3+ny));
					next.setCharAt(nx*3+ny, temp);

					int num = Integer.parseInt(next.toString());
					if(!hashMap.containsKey(num)) {
						hashMap.put(num, hashMap.get(nowNum)+1);
						queue.add(num);
					}
				}
			}
		}
		if(hashMap.containsKey(123456789)) {
			System.out.println(hashMap.get(123456789));
		} else {
			System.out.println("-1");
		}

	}
}
