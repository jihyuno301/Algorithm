package AlgorithmCourse;

import java.util.Arrays;

public class ComparatorExample {
	public static void main(String[] args) {
		Student[] students = new Student[] {
				new Student("김길동", 201632014),
				new Student("오길동", 201632014),
				new Student("박길동", 201632020),
				new Student("이길동", 201532013),
				new Student("정길동", 201732011)
		};

		System.out.println(Arrays.toString(students));
		Arrays.sort(students, new StudentIdComparator());
		System.out.println(Arrays.toString(students));

	}

}
