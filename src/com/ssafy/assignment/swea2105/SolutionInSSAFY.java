package com.ssafy.assignment.swea2105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolutionInSSAFY {
	private static int[][] m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			m = new int[N][N];
			for (int i = 0; i < m.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m.length; j++) {
					m[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			디저트 최대값 변수
			int maxCnt = -1;
//			각 정점에서 r,c 탐색시작, 탐색할 방향 지정(우하), 시계방향, 아예 사각형을 지정하자 w, h
//			출발좌표 (r,c), w, h, 4중 for
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int w = 1; w < N; w++) {
						for (int h = 1; h < N; h++) {
//							배열범위 벗어나는지 체크
							if(r+w+h >= N || c-h < 0 || c+w >= N) continue;
							int cnt = go(r,c,w,h); // 디저트 개수 세기, 중복디저트가 있으면 -1
//							최대값 체크
							if(maxCnt < cnt) {
								maxCnt = cnt;
							}
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
		}// end of for testCase
		System.out.print(sb.toString());
	}// end of main
	
	private static boolean[] flag = new boolean[101]; // 디저트 중복 여부 판단, 0안씀, 1~100
	
	
	/** 출발좌표 (r,c), w,h 정해진 사각형을 탐색하면서 중복하지 않은 디저트 개수를 카운팅해서 리턴, 중복이면 -1*/
	public static int go(int r, int c, int w, int h) {
//		for (int i = 0; i < flag.length; i++) {
//			flag[i] = false;
//		}
		Arrays.fill(flag,false);
		// flag 배열로 체크, 중복이면 return -1;
		for (int i = 0; i <= w; i++) { // 양쪽 끝 포함
			if(flag[m[r+i][c+i]]) return -1; // 같은 디저트가 있었음
			flag[m[r+i][c+i]] = true; // 디저트 먹음 표시
		
			if(flag[m[r+h+i][c-h+i]]) return -1; // 같은 디저트가 있었음
			flag[m[r+h+i][c-h+i]] = true; // 디저트 먹음 표시
		}
		
		for (int i = 1; i < h; i++) { // 양쪽 끝 미포함
			if(flag[m[r+i][c-i]]) return -1; // 같은 디저트가 있었음
			flag[m[r+i][c-i]] = true; // 디저트 먹음 표시
		
			if(flag[m[r+w+i][c+w-i]]) return -1; // 같은 디저트가 있었음
			flag[m[r+w+i][c+w-i]] = true; // 디저트 먹음 표시	
		}
		return (w+h)*2;
	}
}// end of class
