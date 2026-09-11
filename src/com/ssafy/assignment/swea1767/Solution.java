package com.ssafy.assignment.swea1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
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
 * 프로세서 갯수도 세서 pN에 저장
 * 프로세서의 위치를 미리 저장 pR = new int[12]; pC = new int[12]
 * 
 * dfs(int processorNum, int dis) 프로세스 번호, 총 전선 길이
 * 
 * (종료조건)
 * - 마지막 프로세서까지 연결하면 return + 총 전선 길이를 최소 길이와 비교
 * (재귀)
 * (가지치기)
 * - dis길이가 현재 minDis 보다 크면 return; 더 볼 것도 없음
 * 
 * - 가장자리에 있는지 체크 (inCorner())
 * - 가장 자리면 다음 dfs(processorNum + 1, dis)
 * 
 * - 현재 프로세서에서 갈 수 있는 방향 탐색
 * - 4가지 방향에 대해 직진해봄 (방향도 정의해두자)
 * - 아무것도 안 만나면 해당 선의 길이 더하고 dfs(processorNum + 1, dis + d)
 * - 만나면 continue하고 다음 방향 탐색
 * (가지치기)
 * - 모든 방향에서 불가하면? flag 값을 두어 모든 방향에서 불가능했는지 확인 -> 그냥 return
 * 
 * 
 * 연산 수가 생각보다 많진 않을 듯
 * 
 * 
 * 완탐에 가지치기 진행 
 * - 특정 상황에서 해당 프로세서가 전원 연결할 경우의 수가 없는 경우
 * - 지금까지 연결한 전선의 길이가 최소값보다 클 경우
 * 
 * 비트마스킹 사용가능? (이건 모르겠음)
 * 4방향 중 탐색 가능한 경우를 숫자로 저장하고 바로 바로 탐색
 * 상 하 좌 우
 *
 */

public class Solution {
	
	private static int M = 12;
	
	private static int[][] cellMap;
	private static int N, pN, maxConnect, minDis;

	private static int[] pR;
	private static int[] pC;
	
	// 상하좌우 순서
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			cellMap = new int[N][N];
			pN = 0;
			pR = new int[M];
			pC = new int[M];
			int pIdx = 0;
			
			// cell map 생성
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					int cell = Integer.parseInt(st.nextToken());
					cellMap[r][c] = cell;
					if(cell == 1) {
						pN++;
						pR[pIdx] = r;
						pC[pIdx] = c;
						pIdx++;
					}
				}
			}
			
			maxConnect = 0;
			minDis = Integer.MAX_VALUE;
			dfs(0,0,0);
			
			sb.append("#").append(tc).append(" ").append(minDis).append("\n");
		}// end of test_case
		System.out.print(sb.toString());
	}// end of main

	private static void dfs(int pNum, int dis, int connected) {
		// 종료 조건
		if(pNum == pN) {
			if(connected == maxConnect) {
				if(dis < minDis) {
					minDis = dis;
				}
				return;
			}
			else {
				minDis = dis;
				return;
			}
		}
		
		// 재귀
		if(isCorner(pR[pNum], pC[pNum])) { // 가장자리에 위치하면 선 연결 필요 없음
			maxConnect = Math.max(maxConnect, connected+1);
			dfs(pNum+1, dis, connected+1);
		}
		else {
			for (int direct = 0; direct < 4; direct++) {
				int r = pR[pNum];
				int c = pC[pNum];
				
				r += dr[direct];
				c += dc[direct];
				// 해당 방향으로 탐지했을 때, 전원 연결 가능한가?
				boolean flag = true;
				while(inRange(r,c)) {
					if(cellMap[r][c] != 0) flag = false;
					r += dr[direct];
					c += dc[direct];
				}
				// 전원 연결 가능하면 다음 프로세서 탐색, 거리도 추가
				if(flag) {
					// 전선 2로 마킹
					r = pR[pNum] + dr[direct];
					c = pC[pNum] + dc[direct];
					int d = 0;
					while(inRange(r,c)) {
						d++;
						cellMap[r][c] = 2;
						r += dr[direct];
						c += dc[direct];
					}
					// 최대 프로세스 업데이트
					maxConnect = Math.max(maxConnect, connected+1);
					dfs(pNum+1, dis + d, connected+1);
					// 전선 0으로 복귀
					r = pR[pNum] + dr[direct];
					c = pC[pNum] + dc[direct];
					while(inRange(r,c)) {
						cellMap[r][c] = 0;
						r += dr[direct];
						c += dc[direct];
					}
				}
			}
		}
		
		
	}

	private static boolean isCorner(int row, int col) {
		return (row == 0 || row == N-1 || col == 0 || col == N-1); // 이중 하나라도 만족하면 가장자리에 있음
	}
	
	private static boolean inRange(int row, int col) {
		return (row >= 0 && row < N && col >= 0 &&  col < N); // Map 안에 있는지 확인
	}
	
	
}// end of class
