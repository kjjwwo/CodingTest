package com.ssafy.assignment.swea3421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	
	static int[][] unvalid;
	static int ans;
	static int N;
	static int M;
	
	static boolean[] include;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			unvalid = new int[M][2];
			include = new boolean[N];
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				
				unvalid[m][0] = Integer.parseInt(st.nextToken())-1;
				unvalid[m][1] = Integer.parseInt(st.nextToken())-1;
			}
			
			ans = 0;
			dfs(0);
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void dfs(int cnt) {
		if (cnt == N) {
			ans++;
			return;
		}
		
		// 1. cnt번째 재료를 선택하지 않는 경우
		include[cnt] = false;
		dfs(cnt + 1);
		
		// 2. cnt번째 재료를 선택하는 경우
		include[cnt] = true;
		
		if(isValid(cnt)) {
			dfs(cnt + 1);
		}
		
		include[cnt] = false;
	}

	private static boolean isValid(int cnt) {
		
		for (int i = 0; i < M; i++) {
			int a = unvalid[i][0];
			int b = unvalid[i][1];
			
			if((a == cnt && include[b]) || (b == cnt && include[a])) {
				return false;
			}
			
		}
		return true;
	}
	
	
}
