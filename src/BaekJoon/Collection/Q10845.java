/*
Title : 큐
문제 : 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

입력 : 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
출력 : 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */
package BaekJoon.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue queue = new Queue(N); //임의로  배열크기 설정
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
				case "push" :
					queue.push(Integer.parseInt(st.nextToken()));
					break;
				case "front" :
					System.out.println(queue.front());
					break;
				case "back" :
					System.out.println(queue.back());
					break;
				case "size" :
					System.out.println(queue.size());
					break;
				case "empty" :
					System.out.println(queue.isEmpty() ? "1" : "0");
					break;
				case "pop" :
					System.out.println(queue.pop());
					break;
				default :
					System.out.println("queue error");
					break;
			}
		}

	}
}

class Queue {
	int[] arr ;
	int queueSize;
	int front;
	int rear;

	public Queue(int queueSize) {
		front = -1;
		rear = -1;
		this.queueSize = queueSize;
		this.arr = new int[queueSize];
	}

	public boolean isEmpty() {
		return (front==rear);
	}
	public boolean isFull() {
		return (rear==this.queueSize-1);
	}

	public void push(int x) {
		if(isFull()) System.out.println("큐가 가득참");
		else {
			arr[++rear]=x;
		}
	}
	public int pop() {
		if(isEmpty()) return -1;
		else return arr[++front];
	}
	public int size() {
		int count=0;
		for(int i=front+1; i<=rear; i++) count++;
		return count;
	}

	public int front() {
		if(isEmpty()) return -1;
		return arr[front+1];
	}

	public int back() {
		if(isEmpty()) return -1;
		return arr[rear];
	}

}
