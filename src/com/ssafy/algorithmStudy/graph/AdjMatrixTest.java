package com.ssafy.algorithmStudy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrixTest {
	
	private static int V;
	private static int[][] adjMatrix;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		adjMatrix = new int[V][V];
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = adjMatrix[to][from] = 1; // 양방향 간선 처리
			
		}
		
		for (int[] vertex : adjMatrix) {
			System.out.println(Arrays.toString(vertex));
		}
		
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
			
			for (int i = 0; i < V; i++) {
				if(adjMatrix[current][i] == 0 || visited[i]) continue;
				
				queue.offer(i);
				visited[i] = true;
			}
			
		}
		
	}
	
}
