package com.ssafy.assignment.swea14510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionInSSAFY {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] tree= new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int maxTree = 0;
			for (int i = 0; i < tree.length; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				if(maxTree < tree[i]) {
					maxTree = tree[i];
				}
			}
			
			int odd = 0;
			int even = 0;
			for (int i = 0; i < tree.length; i++) {
				tree[i] = maxTree - tree[i];
				if(tree[i] % 2 != 0) odd++;
				even += tree[i]/2;
			}
			int day = 0;
			int min = Math.min(odd, even);
			day = min * 2;
			odd -= min;
			even -= min;
			
			if(odd > even) {
				day += odd * 2 -1;
			}else if(odd < even) {
				day += even / 3 * 4;
				if (even % 3 == 1) day += 2;
				else if (even % 3 == 2) day += 3;
			}else {
				
			}
			
			sb.append("#").append(tc).append(" ").append(day).append("\n");
		}// end of for test_case
		System.out.print(sb.toString());
	}// end of main
}// end of class
