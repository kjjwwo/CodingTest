package com.ssafy.assignment.swea1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author JW
 * 
 * NxN 크기의 맵
 * int[][] map = new int[N][N]
 * 기본 0으로 해두고 지뢰는 -1, 지뢰 만나면 주변에 +1하기
 * 
 * cnt = 0;
 * 
 * 전체를 탐색 -> 반복문으로 돌다가 0을 만나면
 * bfs로 탐색하면서 0을 만나지 않을 때까지 탐색 진행
 * 0을 찾고 그 주변지뢰는 모두 0으로 작성
 * 탐색 끝나면 cnt++
 * 
 * 전체 맵을 탐색하면
 * 다시 한번더 전체 맵을 돌면서 0보다 큰 값을 모두 더해줌
 * 
 * 
 * 
 */

public class Solution {
	private static int[][] map;
	private static int[] dr = {-1,-1,-1,0,0,1,1,1};
	private static int[] dc = {-1,0,1,-1,1,-1,0,1};
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					if(str.charAt(c) == '*') {
						map[r][c] = -1;
					}
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == -1) continue;
					for (int i = 0; i < 8; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						if(map[nr][nc] == -1) {
							map[r][c]++;
						}
					}
					
				}
			}
			
			
			cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == 0) {
						bfs(r,c);
						cnt++;
					}
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] > 0) {
						cnt++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt);
		}
		System.out.print(sb.toString());
	}

	// dfs가 좋지 않나? 한 길로 쭉 가다가 다 찾음녀 올라가고 흠... 아닌가
	private static void bfs(int r, int c) {
		// TODO Auto-generated method stub
		Queue<int[]> queue = new LinkedList<>();
		
		int[] coord = {0,0};
		queue.add(coord);
		while(!queue.isEmpty()) {
			
		}
	}

}
