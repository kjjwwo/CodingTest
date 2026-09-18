package com.ssafy.assignment.swea2105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author JW
 * 
 * N x N 크기의 디저트 카페
 * N^2 만큼 존재
 * 
 * 이동은 항상 대각선 방향으로 이동
 * 
 * 사각형을 그리고 다시 돌아와야 함
 * 
 * 숫자가 같은 곳을 방문할 수 없음
 * 
 * 두칸 이상 움직여야 함
 * 
 * 왔던길 돌아갈 수 없음
 * 
 * 
 * [[0,0],[0,1],[0,2],[0,3],
 * [[1,0],[1,1],[1,2],[1,3],
 * [[2,0],[2,1],[2,2],[2,3],
 * [[3,0],[3,1],[3,2],[3,3],
 * 
 * [왼쪽 아래(+1,-1) -> 오른쪽 아래(+1,+1)] -> 오른쪽 위(-1,+1) -> 왼쪽 위(-1,-1) 순으로 탐색
 * 왼쪽 아래 갈 수 있는지 확인 후 가능하면 이동
 * 
 * dfs로 진행
 * 그냥 탐색 ㄱㄱㄱ
 * 
 * direct에 따라 다음 방향으로 가로, 세로 정해서 따로 저장, 이후 방향 두번째 틀면 바로 쭉 탐색
 * 
 * 리스트에 담고, 겹치는 거 있으면 종료
 * 
 * 두번 꺾으면 쭉 탐색 진행, (w,h,현재 위치) => 리스트에 겹치는 거 있나 탐색 쭉 진행
 * 
 * N을 입력 받아
 * map을 담고
 * 위에서부터 전체 탐색 진행
 * maxDessert = 0;
 * 왼쪽 아래로 이동 가능한 것만 골라서 dfs 진행
 * 탐색하면서 리스트에 담아두고 겹치는 값있는지 계속 탐색 -> boolean[] put = new boolean[100];
 * (+1,-1) -> (+1,+1) -> 이후 쭉 탐색하는 함수(avail(l1,l2,row,col)) -> 그 결과 가능하면 디저트 수 반환 + 불가능하면 -1 반환
 * maxDessert 업데이트
 * 
 */

public class Solution {
	private static int[][] map;

	private static int[] dr = {1,1,-1,-1};
	private static int[] dc = {-1,1,1,-1};

	private static int maxDessert, len1, len2, N;

	private static boolean[] visited;

	private static int dessert;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			
			map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxDessert = -1;
			dessert = 0;
			visited = new boolean[101];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(r+dr[0] >= N || c+dc[0] < 0) continue;
					len1 = 0;
					len2 = 0;
					dfs(r,c,0);
				}
			}
			sb.append("#").append(tc).append(" ").append(maxDessert).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void dfs(int row, int col, int direct) {
		if(direct == 2) {
			len1--;
			len2--;
			if(avail(row,col)) {
				maxDessert = Math.max(maxDessert, dessert);
			}
			return;
		}
		
		visited[map[row][col]] = true;

		if(checkRange(row+dr[direct],col+dc[direct])) {
			if(direct == 0) len1++;
			else if(direct == 1) len2++;
			dfs(row+dr[direct],col+dc[direct],direct);
			if(direct == 0) len1--;
			else if(direct == 1) len2--;
		}
		if(len1 != 0) {
			if(checkRange(row+dr[direct+1],col+dc[direct+1])) {
				if(direct == 0) len1++;
				else if(direct == 1) len2++;
				dfs(row+dr[direct+1],col+dc[direct+1],direct+1);
				if(direct == 0) len1--;
				else if(direct == 1) len2--;
			}
		}
		visited[map[row][col]] = false;
	}

	private static boolean checkRange(int row, int col) {
		return (row >= 0 && row < N && col >= 0 && col < N);
	}

	private static boolean avail(int row, int col) {
		for (int i = 0; i < len1; i++) {
			row += dr[2];
			col += dc[2];
			if(!checkRange(row, col)) return false;
			if(visited[map[row][col]]) return false;
			dessert += map[row][col];
		}
		for (int i = 0; i < len2; i++) {
			row += dr[3];
			col += dc[3];
			if(checkRange(row, col)) return false;
			if(visited[map[row][col]]) return false;
			dessert += map[row][col];
		}
		return true;
	}	
}
