package com.ssafy.assignment.swea1266;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static Queue<int[]> queue;
	
	static int flag = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = 16;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			int T = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			flag = 0;
			
			int[] start = {0,0};
			int[] end = {0,0};
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					int num = line.charAt(j) - '0';
					if (num == 2) {
						start[0] = i;
						start[1] = j;
					}
					else if (num == 3){
						end[0] = i;
						end[1] = j;
					}		
					map[i][j] = num;
				}
			}
			
			// DFS
			dfs(start[0], start[1]);
			
			// BFS
			queue = new LinkedList<>();
			bfs(start[0], start[1]);
			
			sb.append("#").append(test_case).append(" ").append(flag).append("\n");
		}
		System.out.println(sb.toString());
		
	}//main
	static void dfs(int x,int y) {
		visited[x][y] = true;
		
		if (map[x][y] == 3) {
			flag = 1;
			return;
		}
		
		for (int i = 0; i < dx.length; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			
			if(new_x < 0 || new_x >= map.length || new_y < 0 || new_y >= map.length || visited[new_x][new_y] || map[new_x][new_y] == 1) {
				continue;
			}
			else {
				dfs(new_x, new_y);
			}
		}
	}//DFS
	
	static void bfs(int x, int y) {
		queue.offer(new int[] {x,y});
		visited[x][y] = true;
		
//		while(!queue.isEmpty()) {
//			
//		}
	}//BFS
	
	
}//class
