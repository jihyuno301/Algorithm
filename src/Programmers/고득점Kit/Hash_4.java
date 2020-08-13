/*
Title : 베스트앨범
문제 :
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 */
package Programmers.고득점Kit;

import java.util.*;
import java.util.Set;
import java.util.HashSet;

public class Hash_4 {

	static class Song implements Comparable<Song> {
		int id; // 고유번호
		int time; //재생횟수

		public Song(int id, int time) {
			this.id = id;
			this.time = time;
		}

		public int getId() {
			return id;
		}

		public int getTime() {
			return time;
		}

		@Override
		public int compareTo(Song song) {
			// 재생횟수 비교
			return song.getTime() - this.time;
		}
	}

	static class Genre implements Comparable<Genre> {
		int id;
		String name;
		int total;

		public Genre(int id, String name, int total) {
			this.id = id;
			this.name = name;
			this.total = total;
		}

		@Override
		public int compareTo(Genre genre) {
			// 재생횟수 비교
			return genre.total - this.total;
		}
	}

	static String[] findGenre(String[] genres) {
		Set<String> hashSet = new HashSet<>();
		String[] type;

		for (String s : genres) hashSet.add(s);

		type = new String[hashSet.size()];

		Iterator iterator = hashSet.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			type[i++] = (String)iterator.next();
		}
		return type;
	}

	static ArrayList<Integer> findBestSongsByGenre(ArrayList<Song> arrayList) {
		Song[] songs = new Song[arrayList.size()];
		songs = arrayList.toArray(songs);
		Arrays.sort(songs);

		ArrayList<Integer> result = new ArrayList<>();
		if(songs.length == 1) {
			result.add(songs[0].getId());
			return result;
		} else {
			for(int i=0; i<2; i++)
				result.add(songs[i].getId());
			return result;
		}
	}

	static int[] solution(String[] genres, int[] plays) {
		String[] type  = findGenre(genres);
		int[] totalCountByGenre = new int[type.length];

		ArrayList<Song>[] a = new ArrayList[type.length];
		for(int i=0; i<a.length; i++) {
			a[i] = new ArrayList<>();
		}

		for(int i=0; i<plays.length; i++) {
			for (int k = 0; k < type.length; k++) {
				if(genres[i] == type[k]) {
					a[k].add(new Song(i, plays[i]));
					totalCountByGenre[k] += plays[i];
					break;
				}
			}
		}

		// type, a, totalCountByGenre
		// 장르 우선순위 순서
		Genre[] g = new Genre[type.length];
		for(int i=0; i<type.length; i++) {
			g[i] = new Genre(i,type[i], totalCountByGenre[i]);
		}
		Arrays.sort(g);

		ArrayList<Integer> answer1 = new ArrayList<>();
		for(Genre tmp : g) {
			answer1.addAll(findBestSongsByGenre(a[tmp.id]));
		}

		int[] answer2 = new int[answer1.size()];
		for(int i=0; i<answer2.length; i++) {
			// Integer형 ArrayList를 int형 배열로
			answer2[i] = answer1.get(i).intValue();
		}
		return answer2;
	}

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		int[] answer = solution(genres, plays);
		System.out.println(Arrays.toString(answer));

	}
}
