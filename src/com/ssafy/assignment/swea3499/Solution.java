package com.ssafy.assignment.swea3499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			ArrayDeque<String> q1 = new ArrayDeque<String>();
			ArrayDeque<String> q2 = new ArrayDeque<String>();
			
			int firstHalf = (N+1)/2;
			for (int i = 0; i < firstHalf; i++) {
				q1.offer(st.nextToken());
			}
			
			for (int i = 0; i < N/2; i++) {
				q2.offer(st.nextToken());
				
			}
			
			sb.append("#").append(test_case).append(" ");
			
			while (!q1.isEmpty() || !q2.isEmpty()) {
				if (!q1.isEmpty()) {
					sb.append(q1.poll()).append(" ");
				}
				if (!q2.isEmpty()) {
					sb.append(q2.poll()).append(" ");
				}
			}
			sb.append("\n");
//			String[] shuffledCards = new String[N];
//			
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int i = 0; i < N/2; i++) {
//				shuffledCards[i*2] = st.nextToken();				
//			}
//			for (int i = 0; i < N/2; i++) {
//				shuffledCards[i*2+1] = st.nextToken();
//			}
//			sb.append("#").append(test_case).append(" ");
//			for (int i = 0; i < shuffledCards.length; i++) {
//				sb.append(shuffledCards[i]).append(" ");
//			}
//			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
