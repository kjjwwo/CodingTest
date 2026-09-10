package com.ssafy.assignment.swea2806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author JW
 * 
 * N-Queen 문제
 * 
 * nxn 크기의 체스판
 * 
 * n개의 Queen이 서로 공격하지 못하도록 배치 -> 그 경우의 수는?
 * 
 * dfs 사용 - n개의 queen을 모두 배치해보고 다음 차례 다음 차례
 * + 가지치기를 통해 가짓수 줄이기
 * + 돌아가서 탐색하는 백트래킹
 * 이건 순열? 조합? 부분집합? 굳이 따지자면 순열?
 * 
 * n을 입력 받고
 * n x n boolean 배열 생성
 * boolean[n] chessboard = new boolean[n][n]
 * 
 * existR = new boolean[n] >> 생각해보니 같은 행은 고려할 필요 없음
 * existC = new boolean[n]
 * 
 * board의 0,0 위치부터 queen을 하나씩 넣음
 * 이때 dfs 이용
 * 재귀적으로 생각한다면... 현재 칸을 보고, 들어갈 수 있으면 넣고 아니면 다음칸!
 * 
 * dfs(int r){ // row를 한칸씩 내려갈거라서 이렇게 
 * 		if(r == 9)return;
 * 		
 * 		for(c = 0; c < N; c++){
 * 			int r 있음? (existR[] visited와 유사) >> r이 한줄씩 커지면서 하나씩 넣으므로 이건 고려할 필요 없음
 * 			int c 있음? (existC[] visited와 유사)
 * 			
 * 			checkDiagonal(r, c) 둘다 없으면 대각선 확인 1. 왼쪽 대각선 위 확인 2. 오른쪽 대각선 위 확인 -> 최대 2n번
 * 			
 * 			모두 만족하면 board에 넣고
 * 			existC 업데이트
 * 			dfs(cnt+1, r+1); 
 * 			board에 넣은거 빼고
 * 			existC 업데이트
 * 		}
 * }
 * 
 * 
 * 
 * 
 */


public class Solution {
	
	private static boolean[][] chessboard; 	// 체스판
	private static boolean[] existCol;		// 같은 열에 있는지
	
	private static int N;
	private static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			chessboard = new boolean[N][N];
			existCol = new boolean[N];
			
			ans = 0;
			setQueen(0);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}// end of tc
		System.out.print(sb.toString());
	}// end of main
	
	private static void setQueen(int r) {
		if (r == N) {
			ans++;
			return;
		}
		for (int c = 0; c < N; c++) {
			if(existCol[c]) continue;
			if(checkDiagonal(r,c)) continue;
			
			// 해당 칸에 Queen 넣음
			chessboard[r][c] = true;
			existCol[c] = true;
			// 다음행으로 넘어감
			setQueen(r+1);
			
			// 백트래킹
			chessboard[r][c] = false;
			existCol[c] = false;
		}
		
	}

	private static boolean checkDiagonal(int r, int c) {
		int nr = r;
		int nc = c;
		// 왼쪽 대각선
		while(--nr >= 0 && --nc >= 0) { // 왼쪽 위로 가기 때문에 0보다 작은지만 체크, (r>0 || c>0) 이렇게 써도 됨. 
			if(chessboard[nr][nc]) {
				return true;
			}
		}
		nr = r;
		nc = c;
		// 오른쪽 대각선
		while(--nr >= 0 && ++nc < N ) { // 오른쪽 위로 가기 떄문에 row는 0보다 크고, col은 N보다 작아야 함
			if(chessboard[nr][nc]) {
				return true;
			}
		}
		return false;
	}
}// end of class
