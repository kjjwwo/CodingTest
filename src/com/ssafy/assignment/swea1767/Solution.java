package com.ssafy.assignment.swea1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author JW
 * 
 * N x N cell
 * 
 * core의 수는 12개 이하 
 * 
 * dr = {-1, 1, 0, 0}
 * dc = {0, 0, -1, 1}
 * 
 * int[][] cellMap = new int[N][N]
 * 
 * 
 * (완전탐색 - DFS 진행)
 * 프로세서 갯수도 세서 totalProcessorNum에 저장
 * 프로세서의 위치를 미리 저장 pR = new int[12]; pC = new int[12]
 * 
 * processorCnt : 현재까지 탐색한 프로세서 수
 * connectNum : 현재까지 연결한 프로세서 수
 * 
 * dfs(int processorCnt, int connectNum, int dis) 프로세스 번호, 총 전선 길이
 * 
 * (종료조건)
 * - 마지막 프로세서까지 연결하면 return 
 *   + 연결된 프로세서 수가 최대 연결 프로세서(maxConnect)보다 큰거나 같은지 확인 -> 총 전선 길이를 최소 길이와 비교
 * 
 * (재귀)
 * - 가장자리에 있는지 체크 (inCorner())
 * - 가장 자리면 다음 dfs(processorCnt + 1, connectNum+1, dis)
 * 
 * - 현재 프로세서에서 갈 수 있는 방향 탐색
 * - 4가지 방향에 대해 직진해봄 (방향도 정의해두자)
 * - 아무것도 안 만나면 해당 선의 길이 더하고 dfs(processorCnt + 1, connectNum+1, dis + d)
 * - 만나면 continue하고 다음 방향 탐색
 * - 연결하지 않는 경우의 수 추가 dfs(processorCnt+1, connectNum, dis)
 * - 총 4가지 + 1가지 = 5가지 경우의 수
 * 
 * 연산 수가 생각보다 많진 않을 듯
 * 
 * 
 * 비트마스킹 사용가능? (이건 모르겠음)
 * 4방향 중 탐색 가능한 경우를 숫자로 저장하고 바로 바로 탐색
 * 상 하 좌 우
 * 
 * 
 */

public class Solution {
	
	private static int M = 12; // 문제에 설정된 최대 프로세서 수
	
	private static int[][] map;
	
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int N, totalProcessorNum, maxConnect, minDistance;

	private static int[] pCol;
	private static int[] pRow;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			pRow = new int[M];
			pCol = new int[M];
			
			int idx = 0;
			totalProcessorNum = 0;
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] != 0) {
						totalProcessorNum++;
						pRow[idx] = r;
						pCol[idx++] = c;
					}
				}
			}
			
			maxConnect = 0;
			minDistance = Integer.MAX_VALUE;
			dfs(0,0,0);
			
			sb.append("#").append(tc).append(" ").append(minDistance).append("\n");
		}// end of tc
		System.out.print(sb.toString());
	}// end of main


	private static void dfs(int processorCnt, int connectNum, int distance) {
		// 종료 조건
		if(processorCnt == totalProcessorNum) {
			if(connectNum > maxConnect) {
				maxConnect = connectNum;
				minDistance = distance;
			}
			else if(connectNum == maxConnect) {
				minDistance = Math.min(minDistance, distance);
			}
			return;
		}
		
		// 재귀 탐색
		// 현재 프로세서 위치
		int row = pRow[processorCnt];
		int col = pCol[processorCnt];
		
		// 가장자리 체크
		if(inCorner(row, col)) {
			dfs(processorCnt+1, connectNum+1, distance);
		}
		else {
			for (int i = 0; i < 4; i++) { // 상하좌우 방향 체크
				if(checkDirect(i, row, col)) { // 특정 방향으로 전원 열결 가능한지 체크
					int d = connectDirect(i, row, col); // 전원 열결 가능하다면 map에 전선 표기 및 전선 길이 반환
					dfs(processorCnt+1, connectNum+1, distance+d);
					disconnectDirect(i, row, col);
				}
			}
			dfs(processorCnt+1, connectNum, distance);
		}
	}

	// 탐색 종료 후 전선 0으로 제거
	private static void disconnectDirect(int i, int row, int col) {
		while(inMap(row+dr[i], col+dc[i])) {
			row += dr[i];
			col += dc[i];
			
			map[row][col] = 0;
		}
		return;
	}

	// 연결 가능 확인 후 전선을 2로 map에 표시
	private static int connectDirect(int i, int row, int col) {
		int distance = 0;
		while(inMap(row+dr[i], col+dc[i])) {
			row += dr[i];
			col += dc[i];
			distance++;
			map[row][col] = 2;
//			if(map[row][col] != 0) {
//				System.out.println("Connect ERROR!!!");
//				return -1;
//			}
		}
		
		return distance;
	}

	// 현재 방향으로 전원 연결이 가능한가. 해당 방향으로 0이외의 값이 존재하는가
	private static boolean checkDirect(int i, int row, int col) {
		while (inMap(row+dr[i], col+dc[i])) {
			row += dr[i];
			col += dc[i];
			
			if(map[row][col] != 0) {
				return false;
			}
		}
		return true;
	}

	// 현재 좌표가 map 안에 있는가
	private static boolean inMap(int row, int col) {
		return (row >= 0) && (row < N) && (col >= 0) && (col < N);
	}
	// 현재 좌표가 가장자리에 있는가
	private static boolean inCorner(int row, int col) {
		return (row == 0) || (row == N-1) || (col == 0) || (col == N-1);
	}
}// end of class
