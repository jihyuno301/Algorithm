package AlgorithmCourse;

class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}

class LinkedList {
	Node head = null;

	public void addHead(int value) {
		head = new Node(value, head);
	}

	public void remove(int value) {
		Node node = head; // 현재 노드를 가르키는 변수
		Node prev = null; // 현재 노드의 앞 부모 노드를 가르키는 변수
		while (node != null) {
			if (node.value == value) {
				if (prev == null) head = head.next; // 삭제할 노드가 head이면
				else prev.next = node.next; // 삭제할 노드가 head가 아니면
				break;
			}
			prev = node;
			node = node.next;
		}
	}

	public void print() {
		Node node = head;
		while (node != null) {
			System.out.printf("%d ", node.value);
			node = node.next;
		}
		System.out.println();
	}
}

public class LinkedList1 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; ++i) {
			list.addHead(i);
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
