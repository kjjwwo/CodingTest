package swea.d2.SWEA_21425;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
21425. += (D2)
 */

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			
			while (A <= N && B <= N) {
				if (A > B) {
					B += A;
				}
				else {
					A += B;
				}
				cnt++;
			}
			
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}	
}
