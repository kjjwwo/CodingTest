package com.ssafy.assignment.swea6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] Gyu;
	static int[] Iny;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			Iny = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				Iny[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.toString(Iny);
			for (int i=1, j=0; i <= 18; i++) {
				if(Iny[j] == i) continue;
				Gyu[j++] = i;
			}
			
			ans = 0;
			dfs(0,0);
			
			sb.append("#").append(test_case).append(" ").append(ans).append("/n");
		}	
		
	}
	
	static void dfs(int cnt, int score) {
		if(cnt == 9) {
			if(score > 181440) {
				ans++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			dfs(cnt+1, score+game(Gyu[cnt], Iny[cnt]));
		}
	}
	
	static int game(int a, int b) {
		return (a>b)?a + b:0;
	}
}
