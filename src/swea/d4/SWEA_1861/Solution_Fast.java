package swea.d4.SWEA_1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Fast {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int length = N*N+1;
			int[][] A = new int[length][2]; // 크기가 N*N+1 배열 생성 {x, y}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					A[num][0] = i;
					A[num][1] = j;
				}
			}
			A[0][0] = -1;
			A[0][1] = -1;
			
			
			int cur = 1;
			int maxCnt = 0;
			int maxIdx = Integer.MAX_VALUE;
			for (int i = length-1; i > 0; i--) {
				if (cur >= maxCnt) {
					maxCnt = cur;
					maxIdx = i;
				}
				if (Math.abs(A[i][0] - A[i-1][0]) + Math.abs(A[i][1] - A[i-1][1]) == 1) {
					cur++;
				}else {
					cur = 1;	
				}
			}
			sb.append("#").append(testCase).append(" ").append(maxIdx).append(" ").append(maxCnt).append("\n");
			
			
		} // end of testCase
		System.out.print(sb.toString());
	} // end of main
} // end of class
