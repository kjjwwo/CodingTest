package swea.d4.SWEA_1861;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
/**
3
9 3 4
6 1 5
7 8 2
외길이니까 BFS, DFS 쓰지 않는다. visited 배열 쓰지 않는다
메모이제이션

 */
public class Solution_study {
	private static int[][] A;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine()); // 1 ~ 1000
			A = new int[N][N];
			for (int i = 0; i < A.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < A.length; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxCnt = 0; // 최대 이동할 수 있는 방의 개수
			int index = Integer.MAX_VALUE; // 최대 이동을 위해 출발할 방위치 (숫자) (작은 수를 찾음)
			// 모든 정점에서 출발해서, 갈 수 있는 칸으로 탐색
			for (int r = 0; r < A.length; r++) {
				for (int c = 0; c < A.length; c++) {
					int cnt = go(r, c); // (r, c)에서 출발해서 이동 가능한 칸수
					// 이동 가능 칸수의 최대값
					if (maxCnt < cnt || (maxCnt == cnt && index > A[r][c])) {
						maxCnt = cnt;
						index = A[r][c];
						
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(index).append(" ").append(maxCnt).append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
	private static int[] dr = {-1, 1, 0, 0};// 상하좌우
	private static int[] dc = {0, 0, -1, 1};
	
	private static int go(int r, int c) {
		int cnt = 1; // r,c 에서 이동할 수 있는 방 개수
		
		while(true) {
			int nextNum = A[r][c]+1; // 절약!
			// 현재칸 r,c 에서 인접칸 상하좌우 나보다 1큰수 방 가기
			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[0];
				int nc = c + dc[0];
				if (0<=nr && nr<N && 0<=nc && nc<N && nextNum == A[nr][nc]) { // 배열 범위 내, 나보다 1큰수 이동 <= 테두리를 둘러서 범위 검사 제외하기
					r = nr;
					c = nc;
					cnt++;
					break; // 외길이니까 (100ms 절약)
				}
				
			}
			break; // for break 문
		}
		return cnt;
	}
	
	
} // end of class
