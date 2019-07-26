//오름차순 정렬된 순서로 value가 링크드 리스트에 추가되도록 구현하라.
//dummy node 생성
package AlgorithmCourse;

class Node_2 {
	int value;
	Node next;

	public Node_2(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}
class LinkedList_2 {
	Node dummy = new Node(-1, null);

	public void addHead(int value) {
		dummy.next = new Node(value, dummy.next);
	}

	public void remove(int value) {
		Node node = dummy.next;
		Node prev = dummy;
		while (node != null) {
			if (node.value == value) {
				prev.next = node.next;
				break;
			}
			prev = node;
			node = node.next;
		}
	}

	// 정렬된 순서로 value를 삽입함
	public void addOrdered(int value) {
		Node node = dummy.next;
		Node prev = dummy;
		while(node != null) {
			if(node.value >= value) break;
			prev = node;
			node = node.next;
		}
		prev.next = new Node(value, node);
	}

	public void print() {
		Node node = dummy.next;
		while (node != null) {
			System.out.printf("%d ", node.value);
			node = node.next;
		}
		System.out.println();
	}
}

public class LinkedList2 {
	public static void main(String[] args) {
			LinkedList_2 list = new LinkedList_2();
			for (int i = 1; i < 10; i += 2) {
				list.addOrdered(i);
				list.print();
			}
			for (int i = 0; i < 10; i += 2) {
				list.addOrdered(i);
				list.print();
			}
			for (int i = 1; i < 10; i += 2) {
				list.remove(i);
				list.print();
			}
			for (int i = 0; i < 10; i += 2) {
				list.remove(i);
				list.print();
			}
		}


}
