package com.ssafy.assignment.swea6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {
	
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
			Gyu = new int[9];
			
			visited = new boolean[19];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				Gyu[i] = Integer.parseInt(st.nextToken());
				visited[Gyu[i]] = true;
			}
			for (int i=1, j=0; i <= 18; i++) {
				if(visited[i]) continue;
				Iny[j++] = i;
			}
			
			visited = new boolean[9];
			ans = 0;
			dfs(0,0,0);
			
			sb.append("#").append(test_case).append(" ").append(ans).append(" ").append(362880-ans).append("\n");
		}	
		System.out.println(sb.toString());
	}
	
	static void dfs(int cnt, int scoreG, int scoreI) {
		if(cnt == 9) {
			if(scoreG > scoreI) {
				ans++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			dfs(
				cnt+1, 
				scoreG+game(Gyu[cnt], Iny[i]), 
				scoreI+game(Iny[i], Gyu[cnt])
			);
			visited[i] = false;
		}
	}
	
	static int game(int a, int b) {
		return (a>b)?a + b:0;
	}
}
