package com.ssafy.assignment.swea1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author JW
 * 
 * 첫번째 입력 T (test_case)
 * 두번째 입력 - 점원의 수: N, 선반의 높이 : B
 * 세번째 입력 - 점원의 키
 * 
 * N개 조합 + 뽑는 갯수가 정해져 있지 않음 => 재귀로 구현 => 부분 집합 문제
 * 
 * 각 직원을 선택/미선택하는 부분집합 탐색
 * 시간복잡도 O(2^N)
 * (N <= 20)이므로 약 100만 가지 -> 충분히 가능
 * 
 * 최대 키 20만
 * 
 * B를 넘는 것 중 현재 등록된 최소보다 더 큰 거 나오면 종료
 * 
 * 
 */

public class Solution {
	
	private static int N, B;
	private static int[] staff;
	private static int minHeight;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			staff = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				staff[i] = Integer.parseInt(st.nextToken());
			}
			
			minHeight = Integer.MAX_VALUE;
			dfs(0,0);
			sb.append("#").append(tc).append(" ").append(minHeight-B).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void dfs(int cnt, int sum) {
		// 가지치기 (B보다 sum이 커지면 바로 종료)
		if(sum >= B) {
			if(sum < minHeight) {
				minHeight = sum;
			}
			return;
		}
		// 종료 조건
		if(cnt == N) {
			return;
		}
		// 재귀 조건
		dfs(cnt+1, sum+staff[cnt]);
		dfs(cnt+1, sum);
	}
}
