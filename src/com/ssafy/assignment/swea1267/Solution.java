package com.ssafy.assignment.swea1267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author JW
 * 
 * 작업순서
 * 
 * 입력 V, E
 * 
 * 위상정렬 문제
 * 
 * N개 크기의 진입차수, 진출차수를 저장할 배열 생성
 * 이걸 N개 크기로 설정하고 여기에다가 업데이트를 하자
 * indegree(진입차수)
 * outdegree(진출차수)
 * 
 * int[][] degree = new int[V][2]로 위 degree 저장
 * int[][] edge = new int[E][2]로 연결 배열 넣기
 * E를 입력 받을 때, 첫번째 자리는 outdegree++, 두번째 자리는 indegree++
 * 
 * queue를 만들고, 빌 때까지 반복
 * 
 * 일단 첫번째로 진입차수가 0인 것 모두 넣고, 하나씩 빼면서 노드 방문,
 * while(!q.isEmpty()){
 * 		int node = q.poll();
 * 		edge를 탐색하면서 연결된 부분 확인하고 제거? 
 * 		indegree--;
 * 		if(뺀것이 indegree가 0이면) queue에 추가
 * }
 * 
 */


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[][] degree = new int[V+1][2]; // indegree, outdegree 순서로 저장, 0은 사용하지 않음
			int[][] edge = new int[E][2];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < E; i++) { // edge 연결 저장
				edge[i][0] = Integer.parseInt(st.nextToken()); // 출발 노드
				edge[i][1] = Integer.parseInt(st.nextToken()); // 도착 노드
				degree[edge[i][0]][1]++; // 출발 노드는 outdegree 증가
				degree[edge[i][1]][0]++; // 도착 노드는 indegree 증가
			}
			
			Queue<Integer> queue = new LinkedList<>();
			
			for (int i = 1; i <= V; i++) {
				if(degree[i][0] == 0) {
					queue.add(i);
				}
			}
			
			int[] ans = new int[V];
			int index = 0;
			
			while(!queue.isEmpty()) {
				int vertex = queue.poll();
				ans[index++] = vertex;
				for (int i = 0; i < E; i++) { 	// edge를 모두 탐색
					if(edge[i][0] == vertex) { 	// 출발 노드가 vertex라면
						int dEdge = edge[i][1];	// 도착 노드
						degree[dEdge][0]--;    	// 도착 노드의 indegree--
						if(degree[dEdge][0] == 0) { // 이때, 도착 노드의 indegree 값이 0이라면
							queue.add(dEdge);	// queue에 도착 노드 값 추가
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int v : ans) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
		}// end of tc
		System.out.print(sb.toString());
	}// end of main
}// end of class
