/*
Title : 스택
문제 : 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 다섯 가지이다.
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

입력 : 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
출력 : 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */
package BaekJoon.Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10828 {
    public static class Stack {
        int N;
        int[] stack;
        int top;

        public Stack(int N) {
            this.N = N;
            stack = new int[N];
            top = -1;
        }

        public void push(int x) {
            stack[++top] = x;
        }

        public int pop() {
            int num;
            if (isEmpty()==0) {
                num = stack[top];
                --top;
                return num;
            }
            return -1;
        }

        public int isEmpty() {
            if(top==-1) return 1;
            return 0;
        }

        public int size() {
          int count = 0;
          for(int i=top; i>-1; --i) {
              ++count;
          }
          return count;
        }

        public int peek() {
            if(isEmpty()==1) return -1;
            return stack[top];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Stack stack = new Stack(N);
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            String str = st.nextToken();
            switch(str) {
                case "push" :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    System.out.println(stack.pop());
                    break;
                case "top":
                    System.out.println(stack.peek());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty());
                    break;
                default :
                    System.out.println("error");
                    break;
            }
        }
    }
}


