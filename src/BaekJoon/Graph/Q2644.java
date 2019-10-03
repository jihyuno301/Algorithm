/*
Title : 촌수계산
URL : https://www.acmicpc.net/problem/2644
 */
package BaekJoon.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2644 {
	public static ArrayList<Vertex> vertexes = new ArrayList<>();

	public static class Vertex {
		int parent = 0;
		int vertex = 0;
		public Vertex(int parent, int vertex) {
			this.parent = parent;
			this.vertex = vertex;
		}
		public int getVertex() { return this.vertex; }
		public int getParent() { return this.parent; }
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); // 사람 수
		int A = scan.nextInt(); // 정점 A
		int B = scan.nextInt(); // 정점 B
		int E = scan.nextInt(); // 간선의 개수

		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
        for(int i=0; i<E; i++) {
        	int a = scan.nextInt(); // 부모
        	int b = scan.nextInt(); // 자식
        	Vertex vertex = new Vertex(a, b);
        	vertexes.add(vertex); // 정점간 관계
        	list[a].add(b); // 유향트리구현
		}

		ArrayList<Integer> vertex1 = new ArrayList<>(); // 정점 A의 부모 및 조상
        ArrayList<Integer> vertex2 = new ArrayList<>(); // 정점 B의 부모 및 조상

		Vertex v1 = new Vertex(getFindVertex(A).getParent(), getFindVertex(A).getVertex());
		Vertex v2 = new Vertex(getFindVertex(B).getParent(), getFindVertex(B).getVertex());

		getFindParentVertexes(v1, vertex1);
		getFindParentVertexes(v2, vertex2);

//		System.out.println(vertex1.toString());
//		System.out.println(vertex2.toString());


	}

	public static Vertex getFindVertex(int n) {
		for(Vertex v : vertexes) {
			if(v.getVertex() == n) return v;
		}
		return null;
	}
	// 부모정점을 찾으려하는 정점객체, 부모정점을 저장하려하는 배열
	public static ArrayList<Integer> getFindParentVertexes(Vertex v, ArrayList<Integer> list) {
		int parent = v.getParent();
		if(parent == 0) return list;
		list.add(parent);
		return getFindParentVertexes(getFindVertex(parent), list);

	}
}
