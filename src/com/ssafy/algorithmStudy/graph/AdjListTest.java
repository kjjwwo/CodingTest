package com.ssafy.algorithmStudy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjListTest {
	
	static class Node{
		int to;
		Node next;
		
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + "]";
		}
	}

	private static Node[] adjList;
	private static int V;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		adjList = new Node[V];
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]); // 앞으로 삽입하는 알고리즘 + 그래프 탐색 시 
			adjList[to] = new Node(from, adjList[to]);
		}
		
//		for (Node node : adjList) {
//			System.out.println(node);
//		}
		
		bfs(0);
	}
	
	static void bfs(int start) { // 큐에 들어갈 때 방문 처리!
		
		Queue<Integer> queue = new ArrayDeque<>(); // 큐에 넣을 정보 : 탐색 처리에 필요한 정보 (탐색할 정점의 정보, 너비, 경로 등)
		boolean[] visited = new boolean[V];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			System.out.println((char)(current+65));
			
			for (Node temp = adjList[current]; temp != null; temp = temp.next) { // current 정점의 인접정점 탐색
				if(visited[temp.to]) continue;
				
				queue.offer(temp.to);
				visited[temp.to] = true;
			}
			
		}
		
	}
	
}
