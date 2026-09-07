package com.ssafy.assignment.swea9229;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			
			int max = -1;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N-1; i++) {
				if(arr[i] > M) {continue;}
				for (int j = i+1; j < N; j++) {
					int sum = arr[i] + arr[j];
					if (sum > M) {continue;}
					if (sum > max) {max = sum;}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb.toString());
	}//main
}//class
