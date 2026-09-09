package com.ssafy.assignment.swea6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	
	static int[] gyu;
	static int[] in;
	static boolean[] visited;
	
	static int win;
	static int lose;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			gyu = new int[9];
			in = new int[9];
			visited = new boolean[9];
			
			win = 0;  // 규영이 승리 수
			lose = 0; // 규영이 패배 수(인영이 승리 수)
			
			boolean[] isGyu = new boolean[19];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 규영이 카드
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				isGyu[gyu[i]] = true;
			}
			
			// 인영이 카드
			int idx = 0;
			
			for (int i = 1; i < 19; i++) {
				if(!isGyu[i]) {
					in[idx++] = i;
				}
			}
			
			dfs(0,0,0);
			
			sb.append("#").append(test_case).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.print(sb.toString());
	}// end of main



	static void dfs(int cnt, int gyuScore, int inScore) {
		
		// 인영이의 9장 카드 순서를 모두 결정
		if(cnt == 9) {
			if(gyuScore > inScore) {win++;}
			else if(inScore > gyuScore) {lose++;}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			
			int inCard = in[i];
			int gyuCard = gyu[cnt];
			int score = in[i] + gyu[cnt];
			
			visited[i] = true;
			if(gyuCard > inCard) {
				dfs(cnt+1, gyuScore+score, inScore);
			}
			else {
				dfs(cnt+1, gyuScore, inScore+score);
			}
			// 백트래킹
			visited[i] = false;
			
		}
	}
	
}// end of class
