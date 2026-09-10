package com.ssafy.assignment.swea6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionInSSAFY {
	
	private static int[] gArr, iArr;
	private static final int M = 9;
	private static int winCnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			boolean[] isPicked = new boolean[19];
			gArr = new int[M];
			iArr = new int[M];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				gArr[i] = Integer.parseInt(st.nextToken());
				isPicked[gArr[i]] = true;
			}
			for (int i=1, j=0; i < 19; i++) {
				if(!isPicked[i]) iArr[j++] = i;
			}
			
			winCnt = 0;
			permutation(0,0,0,0);
			System.out.println("#"+test_case+" "+winCnt+" "+(362880-winCnt));
		}
	}
	
	static void permutation(int cnt, int flag, int gScore, int iScore) {
		if(cnt == M) {
			if(gScore > iScore) winCnt++;
			return;
		}
		
		for (int i = 0; i < M; i++) {
			if((flag & 1 << i) != 0) continue;
			
			int sum = gArr[cnt] + iArr[i];
			permutation(cnt+1, flag | 1 << i, gScore+(gArr[cnt]>iArr[i]?sum:0), iScore+(gArr[cnt]>iArr[i]?sum:0));
		}
	}
	
}
