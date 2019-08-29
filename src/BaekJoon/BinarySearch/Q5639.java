/*
Title : 이진 검색 트리
문제 : https://www.acmicpc.net/problem/5639
 */
package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Q5639 {
	static class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}
		//포스트오더로 출력
		public void print() {
			//1.현단계 작업을 구현
			//2.재귀호출 구현
			//3.재귀 종료조건
			if(this.left != null) this.left.print();
			if(this.right != null) this.right.print();
			System.out.println(this.value);
		}
	}

	static ArrayDeque<Integer> deque = new ArrayDeque<>();

	//입력받은 값들을 프리오더로 이진검색트리 생성
	static Node parsePreOrder(int min, int max) {
		if(deque.size() == 0) return null;
		//가장 먼저 들어간 값을 가져온다.
		int value = deque.getFirst();
		if(value < min || value > max) return null;
		deque.removeFirst();
		Node node = new Node(value);
		node.left = parsePreOrder(min, node.value);
		node.right = parsePreOrder(node.value, max);
		return node;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			//더이상 입력값이 없는 경우
			if(str == null || str.trim().length() == 0) break;
			deque.addLast(Integer.parseInt(str));
		}
		//입력받은 값들을 프리오더로 이진검색트리 생성
		Node node = parsePreOrder(Integer.MIN_VALUE, Integer.MAX_VALUE);
		//포스트오더로 출력
		node.print();
	}
}
