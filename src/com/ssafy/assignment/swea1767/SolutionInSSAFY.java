package com.ssafy.assignment.swea1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SolutionInSSAFY {
	private static int N;
	private static int[][] map;
	private static ArrayList<int[]> list;
	private static int max;
	private static int min;
	private static int totalCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1 && i>0 && i <N-1 && j>0 && j<N-1) { // 가장자리가 아닌 코어는 리스트에 추가
						list.add(new int[] {i,j});
					}
				}
			}
			
			totalCnt = list.size(); // 가장자리가 아닌 코어 개수
			go(0,0,0);
			System.out.println("#"+tc+" "+min);
		}
	}

	private static void go(int index, int cCnt, int lCnt) { // index: 부분집합에 고려할 코어 인덱스, cCnt: 현재까지 연결된 코어수, lCnt: 현재까지 연결된 코어 전선 수
		
	}
	private static boolean isAvailable(int r, int c, int d) { // r, c 위치에서 d 방향으로 전선 놓기 가능 체크체크: 가지치기에서 사용
		return true;
	}
	 
	private static int setStatus(int r, int c, int d, int s) { // r, c 위치에서 d 방향으로 셀에 s라고 세팅하기 (전선 놓기 및  지우기)
		// 0: 빈칸, 1: 코어, 2: 전선
		
		
		return 0; // 전선 길이의 합 (전선 놓기에서 사용)
	}
}
