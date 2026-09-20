package com.ssafy.assignment.swea1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * @author JW
 * 
 * NxN 크기의 맵
 * N(1 ≤ N ≤ 300) 
 * int[][] map = new int[N][N]
 * map[r][c]
 *  -1: 지뢰
 *   0: 주변 지뢰 없음
 * 1~8: 주변 지뢰 개수
 * 
 * 
 * 1. 각 칸 주변의 지뢰 개수 계산
 * int[] dr = {-1,-1,-1,0,0,1,1,1}
 * int[] dc = {-1,0,1,-1,1,-1,0,1}
 * 
 * 
 * 2. 모든 0을 찾아 BFS
 * for(int r = 0; r < N; r++)
 * 	for(int c = 0; c < N; c++)
 * 		if(map[r][c] == 0 && !visited[r][c])
 * 			bfs(r,c);
 * 			cnt++;
 * 
 * visited로 방문 여부 관리 map이랑 똑같이 생긴 걸로 (boolean)
 * 0이 아닌 숫자칸도 visited 처리
 * 하지만 queue에는 0만 넣음
 * 
 * 3. BFS로 0 탐색 끝나고 아직 안 열린 칸 계산
 * 
 */

public class Solution {
	
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int[] dr = {-1,-1,-1,0,0,1,1,1};
	private static int[] dc = {-1,0,1,-1,1,-1,0,1};
	private static int cnt;
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			cnt = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			// map 입력 받기
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					if(str.charAt(c) == '*') {
						map[r][c] = -1;
					}
				}
			}
			
			// map 설정
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == -1) continue; // 지뢰가 있으면 패스
					// 0이면 지뢰 갯수 체크
					int mine = 0;
					for (int i = 0; i < 8; i++) {
						if(r+dr[i] < 0 || r+dr[i] >= N || c+dc[i] < 0 || c+dc[i] >= N) continue;
						if(map[r+dr[i]][c+dc[i]] == -1) {
							mine++;
						}
					}
					map[r][c] = mine;
				}
			}
			
			// 0인 부분 확인하고 열기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == 0 && !visited[r][c]) {
						bfs(r,c);
						cnt++;
					}
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] != -1 && !visited[r][c]) {
						cnt++;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {row,col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			int[] coord = queue.poll();
			int r = coord[0];
			int c = coord[1];
			
			for (int i = 0; i < 8; i++) {
				
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(visited[nr][nc]) continue;
				
				if(map[nr][nc] == -1) continue;
				
				visited[nr][nc] = true;
				
				if(map[nr][nc] == 0) {
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}
}
