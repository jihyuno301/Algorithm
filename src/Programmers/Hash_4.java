package Programmers;

import java.util.*;
import java.util.Set;
import java.util.HashSet;

public class Hash_4 {

	class Solution {

		static class Song implements Comparable<Song> {
			int id; // 고유번호
			int times; //재생횟수

			public Song(int id, int times) {
				this.id = id;
				this.times = times;
			}

			public int getId() {
				return id;
			}

			public int getTimes() {
				return times;
			}

			@Override
			public int compareTo(Song song) {
				// 재생횟수 비교
				if(this.time > song.getTimes()) return this.time-song.getTimes();
				return song.getId() - this.id;
			}
		}

		static List<String> findGenre(String[] genres) {
			Set<String> hashSet = new HashSet<>();
			List<String> arrayList = new ArrayList<>();

			for(String s : genres) hashSet.add(s);
			Iterator iterator = hasSet.iterator();
			while(iterator.hasNext()) {
				arrayList.add(iterator.next());
			}

			return arrayList;

		}

		public int[] solution(String[] genres, int[] plays) {
			List<String> genre = findGenre(genres);

			for(int i=0; i<genre.size(); i++) {
				genre[i] = new ArrayList<Song>();
			}

			for(int i=0; i<plays.length; i++) {
				for(int j=0; j<genre.size(); j++) {
					if(genre.get(j) == genres[i] ) {
						genre[j].add(new Song(i,plays[i]));
						break;
					}
				}
			}

			// 장르 우선순위 인덱스
			int[] arr = new int[genre.size()];

			// 속한 노래가 많이 재생된 장르별로 정렬
			for(int i=0; i<genre.size(); i++) {
				for(int j=0; j<genre[i].size(); j++) {
					arr[i] += genre[i].get(j).getTimes();
				}
			}

			Arrays.sort(arr);

			// 장르 내에서 많이 재생된 노래 먼저 수록, 고유번호가 낮은 순




		}
	}
}
