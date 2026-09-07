package com.ssafy.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 고정 크기 sliding window
public class SlidingWindow {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long slidingWindow = 0;
		
		for (int i = 0; i < m; i++) {
			slidingWindow += arr[i];
		}
		
		long maxValue = slidingWindow;
		
		for (int i = m; i < n; i++) {
			slidingWindow += arr[i];	// 새로 들어오는 값
			slidingWindow -= arr[i-m];	// 빠져나가는 값
			maxValue = Math.max(maxValue, slidingWindow);
		}
		
		System.out.println(maxValue);
	}
}
