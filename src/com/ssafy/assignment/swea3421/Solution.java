package com.ssafy.assignment.swea3421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author JW
 * 
 * Solution 1-1
 * 1부터 N까지 N개 재료 존재
 * 가능한 많은 종류의 버거
 * 같이 있으면 불가능한 재료 쌍 존재
 * M개의 재료 쌍이 주어졌을 때, N개의 재료로 최대 몇 가지 버거를 제작 가능?
 * 포한된 재료가 같다면 순서에 상관 없이 같은 종류의 버거임 (조합 -> 부분집합)
 * 
 * 주어지는 M개의 쌍에는 같은 쌍이 존재할 수도 있음
 * 
 * 1 <= N <= 20
 * 0 <= M <= 400
 * 
 * 2^20 = 약 1,000,000개 부분 집합 존재 
 * 각 부분 집합 별로 400번 같은 조합이 있는지 검색한다면? 약 400,000,000번 탐색 필요 -> 4억번
 * 0000 0000 0000 0000
 * 0000 0000 0000 0001
 * 0000 0000 0000 0010
 * 0000 0000 0000 0011
 *          :
 * 1111 1111 1111 1110
 * 1111 1111 1111 1111
 * 
 * 불가능한 조합 필터링 필요
 * if 3 5 불가
 * 0000 0000 0001 0100 -> 기존의 값과 & 연산
 * 
 * 0000 0000 0001 0100과 동일한 값이라면 불가능한 조합 포함 부분집합 후보 제거
 * 
 * 
 * for(int i = 1; i <= (1 << N); i++){
 * 		filter = 1 << M[0] | 1 << M[1];	
 * 		result = i & filter;
 * 		if result == filter:
 * 			continue;
 * 		cnt++
 * }
 * 
 * 
 * 
 * Solution 1-2
 * 
 * 조합 불가능한 경우의 수 찾는 법
 * N 크기의 배열을 만들어 각각의 재료 별로 함께 들어가면 안되는 조합을 모두 체크해둔다. 
 * 
 * if M = 5
 * 1 2
 * 2 3
 * 2 4
 * 2 5
 * 4 5
 * 
 * 1번 재료와 같이 넣으면 안되는 재료: 0000 0000 0000 0010
 * 2번 재료와 같이 넣으면 안되는 재료: 0000 0000 0001 1101
 * 3번 재료와 같이 넣으면 안되는 재료: 0000 0000 0000 0010
 * 4번 재료와 같이 넣으면 안되는 재료: 0000 0000 0001 0010
 * 5번 재료와 같이 넣으면 안되는 재료: 0000 0000 0000 1010
 * 
 * 이런식으로 저장
 * 
 * 추후 해당식을 각각의 부분집합 경우의 수와 & 연산
 * 1번 재료가 있을 때 1번 ban 배열과 &하면 1번쪽은 0이니까 항상 0이고 겹치는 것 중 하나라도 1이면 결과가 0이 아님
 * 따라서 i & ban[j] != 0 이면 continue
 * 
 */

public class Solution {
	
//	static int[][] unvalid;
	static int cnt;
	
	// solution 1-2
	static int[] ban;
	/////////////////
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
//			unvalid = new int[M][2];
			cnt = 0;
			
			// solution 1-2
			ban = new int[N+1];
			/////////////////
			
			for (int m = 0; m < M; m++) {
//				st = new StringTokenizer(br.readLine(), " ");
//				unvalid[m][0] = Integer.parseInt(st.nextToken());
//				unvalid[m][1] = Integer.parseInt(st.nextToken());
				
				// solution 1-2
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				ban[a] |= (1 << (b-1));
				ban[b] |= (1 << (a-1));
			}
			
			for (int i = 0; i < (1 << N); i++) {
				boolean valid = true;
//				for (int j = 0; j < M; j++) {
//					int filter = (1 << (unvalid[j][0]-1)) | (1 << (unvalid[j][1]-1));
//					if((i & filter) == filter) {
//						valid = false;
//						break;
//					}
//				}
				
				for (int j=1; j <= N; j++) {
					if((i & (1 << (j-1))) != 0) {
						if((i & ban[j]) != 0) {
							valid = false;
							break;
						}
					}
				}
				
				if(valid) {cnt++;}
			}
			
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}// end of main
}// end of class
