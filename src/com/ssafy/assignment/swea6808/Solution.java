package com.ssafy.assignment.swea6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] gyu;
	static int[] in;
	
	static boolean[] visited;
	
	static int gyuWin;
	static int inWin;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			gyu = new int[9];
			in = new int[9];
			
			boolean[] isGyu = new boolean[19];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				isGyu[gyu[i]] = true;
			}
			
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if(!isGyu[i]) {
					in[idx++] = i;
				}
			}
			
			visited = new boolean[19];
			gyuWin = 0;
			inWin = 0;
			permutation(0,0,0);
			
			sb.append("#").append(test_case).append(" ").append(gyuWin).append(" ").append(inWin).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void permutation(int gameCnt, int gyuScore, int inScore) {
		if (gameCnt == 9) {
			if(gyuScore > inScore) {
				gyuWin++;
			}
			else if(inScore > gyuScore) {
				inWin++;
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			
			if(visited[gyu[i]]) continue;
			
			visited[gyu[i]] = true;
			int sum = gyu[i] + in[gameCnt];
			if(gyu[i] > in[gameCnt]) {
				permutation(gameCnt+1, gyuScore+sum, inScore);
			}
			else {
				permutation(gameCnt+1, gyuScore, inScore+sum);	
			}
			visited[gyu[i]] = false;
			
		}
		
	}
}
