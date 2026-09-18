package com.ssafy.assignment.swea2115;

/**
 * 
배열
최대값 maxVal = 0;
조합 일꾼1 선택 후 그 다음칸부터 일꾼2
for int r1=0; r1<N; r1++
	for int c1=0; c1<=N-M; c1++
		■■■ val = go(r1,c1), 최댓값 비교
		일꾼1 선택 뒷부분 탐색해보기
		if(r2 == r1)
			for int c2 = c1+M; c2 <=N-M; c2++
				■■■ val = go(r2,c2), 최댓값 비교
		일꾼1 선택 다음 행 탐색해보기
		else	
			for int r2=r1+1; r2<N; r1++
				for int c2=0; c2<=N-M; c1++
					■■■ val = go(r2,c2), 최댓값 비교

syso maxVal

go(r,c) 연속된 M칸에서 부분집합 (제곱의 합) 수익을 리턴
	if(기저조건) // 종료 파트
	else // 재귀 파트


연산 결과가 동일하다면, 한번만 구해서 저장해놓고 사용 : 메모이제이션
memo <= 기존 맵이랑 동일한 크기로 작성 (메모리를 버린다고 하더라도 보통 그대로 진행)

 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2115_벌꿀채취2 {
	private static int N;
	private static int M;
	private static int C;
	private static int[][] map;
	private static int[][] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) { // 최대 50개 테스트 케이스
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 벌통들의 크기 N, 3 ≤ N ≤ 10
			M = Integer.parseInt(st.nextToken()); // 연속으로 채취해야하는 벌통의 개수 M, 1 ≤ M ≤ 5, M <= N
			C = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양 C, 10 ≤ C ≤ 30
			map = new int[N][N]; // 벌통에 담긴 꿀의 양
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					map[i][j] = s.charAt(index) - '0'; // 1 <= 꿀의 양 <= 9, 안쪼갤수 있으면 쪼개지 말자
				}
			}
			memo = new int[N][N-M+1]; // 모든 위치에서 M영역을 지정하여, 부분집합으로 얻을 수 있는 최대 수익을 구해서 저장
//	어차피 모든 위치에서 M영역을 지정하여, 부분집합으로 얻을 수 있는 최대 수익을 구할 것이니까, 미리 계산해서 저장해 두자 
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-M; c++) {
					getHoney(r, c, 0, 0, 0);
				}
			}
			
			int maxTotalVal = 0;
			for (int r1 = 0; r1 < N; r1++) {
				for (int c1 = 0; c1 <= N-M; c1++) {
					// 1번 일꾼 위치 r1, c1
					for (int c2 = c1+M; c2 <= N-M; c2++) { // 1번과 같은행, 다음열부터
						// 2번 일꾼 위치 [r1], c2
						int totalVal = memo[r1][c1] + memo[r1][c2];
						if (maxTotalVal < totalVal) {
							maxTotalVal = totalVal;
						}
					}
					for (int r2 = r1+1; r2 < N; r2++) { // 1번 다음행, 맨 처음열 부터
						for (int c2 = 0; c2 <= N-M; c2++) {
							// 2번 일꾼 위치 r2, c2
							int totalVal = memo[r1][c1] + memo[r2][c2];
							if (maxTotalVal < totalVal) {
								maxTotalVal = totalVal;
							}
						}
					}
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(maxTotalVal).append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
	/** r,c 위치에서 연속된 M칸 영역에서 얻을 수 있는 꿀의 최대 이익 업데이트
	 * index : M칸 영역에서 고려할 원소, sum : 지금까지 선택한 꿀의 합, val : 지금까지 수확한 꿀의 수익  */
	public static void getHoney(int r, int c, int index, int sum, int val) {
		if (sum > C) return;
		if (index == M) {
			if (memo[r][c] < val) memo[r][c] = val; // 추후 C 제한을 여기서 체크해야하는지 확인
			return;
		}
		int temp = map[r][c+index];
		getHoney(r, c, index+1, sum + temp, val + temp*temp);
		getHoney(r, c, index+1, sum, val);
	}
} // end of class







































