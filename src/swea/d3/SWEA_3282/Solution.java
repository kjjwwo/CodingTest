package swea.d3.SWEA_3282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] V = new int[N+1];
			int[] C = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] DPtable = new int[N+1][K+1];
			for (int i = 1; i <= N; i++) {
				for (int k = 1; k <= K; k++) {
					if(k<V[i]) {
						DPtable[i][k] = DPtable[i-1][k];
					}else {
						DPtable[i][k] = Math.max(DPtable[i-1][k], DPtable[i-1][k-V[i]]+C[i]);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(DPtable[N][K]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
