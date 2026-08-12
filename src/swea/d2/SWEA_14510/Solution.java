package swea.d2.SWEA_14510;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] trees = new int[N];
			
			int highest = 0;
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if (trees[i] > highest) {
					highest = trees[i];
				}
			}
			
			int[] gaps = new int[N];
			int needOne = 0;
			int needTwo = 0;
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				gaps[i] = highest - trees[i];
				needTwo += gaps[i] / 2;
				if (gaps[i] % 2 == 1) {
					needOne++;
				}
			}
			
			
			if (needOne == needTwo) {
				cnt += needOne * 2;
			}
			else if (needOne > needTwo) {
				cnt += needTwo * 2;
				needOne -= needTwo;
				cnt += needOne * 2 - 1;
			}
			else {
				cnt += needOne * 2;
				needTwo -= needOne;
				int remainGaps = needTwo * 2;
				cnt += (remainGaps / 3) * 2;
				cnt += remainGaps % 3;
			}
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
}
