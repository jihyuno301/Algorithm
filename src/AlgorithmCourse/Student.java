// Comparable, Comparator 인터페이스를 이용하여 학번, 이름순으로 학생 정렬하기
package AlgorithmCourse;

public class Student {
	String name;
	int id;

	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if((obj instanceof Student) == false) return false;
		Student student = (Student)obj;
		return (this.name == null ? student.name == null : this.name.equals(student.name)) && this.id == student.id;
	}

	@Override
	public String toString() {
		return String.format("Student{id=%d, name=%s}", id, name);
	}

}
