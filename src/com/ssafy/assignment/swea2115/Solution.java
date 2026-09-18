package com.ssafy.assignment.swea2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author JW
 * 
 * NxN 벌통
 * 각 칸에는 꿀의 양 숫자로
 * 벌꿀을 채취하여 최대한 많은 수익 창출
 * 
 * 한번에 채취할 수 있는 최대 꿀 C
 * 선택할 수 있는 벌통의 수 M
 * 
 * 
 * M개의 수가 있을 때, 이중에서 몇개를 골라서 C 이하의 수를 만들어야 함
 * a^2 + b^2 + c^2 < (a+b+c)^2 = a^2 + b^2 + c^2 + 2ab + 2bc + 2cb + abc (따라서 1-9 사이의 자연수 범위에서 이는 항상 성립)
 * 위 식에 따르면 C에 해당하는 수를 고를 때, 최대한 C를 맞추고 큰 수를 찾는 것이 유리, 많이 나누지 않는 것이 유리
 * 
 * 근데! 이는 a+b+c = C라는 전제하에 가능 -> 그냥 구현하자. 
 * 
 * 어떻게 할 수 있을까?
 * 각 양봉업자의 수입이 크면 최종 수입도 가장 큼
 * 단, 채취하는 범위가 겹쳐선 안됨.
 * 
 * -> 모든 경우의 수를 다 구해두고 이 중 가장 좋은 조합을 찾는다.
 * NxN 별통들에서 M크기 만큼의 레이어를 적용했을 때, 나오는 최대 수확량을 찾아서 첫번째 칸에 작성! 탐색은 0에서 (N-M+1)까지
 * 걸리는 시간은? 최대 100칸 -> M개를 골랐을 때, 2^M-1개 조합 고려 가능(부분집합) -> M최대 5, 31개 조합 -> 3100개 조합 미리 정하기 -> 시간 문제 없음
 * 저장 후 이제 탐색!
 * 이 칸에서 바로 뒤로 M-1칸 넘어간 후 해당 칸의 값과 현재 값을 합하여 현재 최댓값과 비교, 크면 업데이트 아니면 말구
 * 이렇게 전체 다 탐색
 * 
 * NxN이므로 (3 <= N <= 10) 최대 100칸 -> 100칸에 대해 모든 경우 탐색 10,000번 가능
 * 
 * [실제 구현]
 * 
 * TC 받기
 * N, M, C 받기
 * 
 * hive = new int[N][N];
 * 여기에 벌통 저장
 * 
 * for(0 -> N)
 * 	for(0 -> N-M+1)
 * 		maxPrice = 0;
 * 		price = calMaxPrice(row, col, 0, 0);
 * 		hive[row][col] = maxPrice;
 * 
 * 다하고 나면 이제 또 탐색 - 조합처럼 하지 말고 전체 다 탐색하는 걸로 진행(일단 - 별로 안크니까)
 * for(0->N)
 * 	for(0->N-M+1){
 * 		bk1 = hive[row1][col1];
 * 		for(0->N)
 * 			for(0 -> N-M+1)
 * 				if(row1 == row2)
 * 					if(col1-M < col2 && col2 < col1+M)
 * 						continue;
 * 				price = hive[row1][col1] + hive[row2][col2];
 * }
 * 
 *   
 * col-M [col-(M-1) ... col-3 col-2 col-1 [col] +1 +2 +3 ... +M-1] col+M
 * 
 * 
 * calMaxPrice(row, col, cnt, sum, price){
 * 	// sum이 C이면 종료
 * 	if(sum == C){
 * 		maxPrice = Math.max(maxPrice, price);
 * 		return;
 * 	}
 * 	// sum이 C를 넘으면 가지치기
 *  if(sum > C){ return;}
 *  
 *  // M개 경우의 수를 다 고려했으면 종료 (종료 조건)
 *  if(cnt == M){
 * 		maxPrice = Math.max(maxPrice, price);
 * 		return;
 * 	}
 *  
 * 	재귀함수로 부분집합 중 합이 최대인 것 찾음
 * 	int cur = hive[row][col+cnt];
 * 	calMaxPrice(row, col, cnt+1, sum+cur, price + cur*cur)
 * 	calMaxPrice(row, col, cnt+1, sum, price)
 * }
 * 
 */

public class Solution {
	private static int N, M, C;
	private static int[][] hive;
	private static int maxPrice;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			hive = new int[N][N];
			
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 0; col < N; col++) {
					hive[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N-M+1; col++) {
					maxPrice = 0;
					calMaxPrice(row, col, 0, 0, 0);
					hive[row][col] = maxPrice;
				}
			}
			
			
//			if(p1[0] == p2[0]) {
//				if(Math.abs(p1[1] - p2[1]) < M) {
//					
//				}
//			}
			
			maxPrice = 0;
			for (int row1 = 0; row1 < N; row1++) {
				for (int col1 = 0; col1 < N-M+1; col1++) {
					int bk1 = hive[row1][col1];
					int bk2 = 0;
					for (int col2 = col1+1; col2 < N-M+1; col2++) {
						bk2 = hive[row1][col2];
						maxPrice = Math.max(maxPrice, bk1 + bk2);
					}
					for (int row2 = row1+1; row2 < N; row2++) {
						for (int col2 = 0; col2 < N-M+1; col2++) {
							bk2 = hive[row2][col2];
							maxPrice = Math.max(maxPrice, bk1 + bk2);
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(maxPrice).append("\n");
		}
		System.out.print(sb.toString());
	}// end of main

	private static void calMaxPrice(int row, int col, int cnt, int sum, int price) {
		// sum이 C이면 종료
		if(sum == C) {
			maxPrice = Math.max(maxPrice, price);
			return;
		}
		// sum이 C를 넘으면 가지치기
		if(sum > C) return;
		// M개의 경우의 수를 다 고려했으면 종료 (종료 조건)
		if(cnt == M) {
			maxPrice = Math.max(maxPrice, price);
			return;
		}
		
		// 재귀 함수로 부분집합 탐색
		int cur = hive[row][col+cnt];
		calMaxPrice(row, col, cnt+1, sum+cur, price+(cur*cur));
		calMaxPrice(row, col, cnt+1, sum, price);
	}
		
}// end of class
