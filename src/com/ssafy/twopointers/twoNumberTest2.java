package com.ssafy.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class twoNumberTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int TARGET = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int s=0, e=0;	
		int sum = 0, ans = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			if(sum >= TARGET) {
				if(sum == TARGET) {
					ans++;
				}
				sum -= arr[s++];
			}
			else {
				if(e == n) {
					break;
				}
				sum += arr[e++];
			}
		}
		
//		while(e<n) {
//			
//			if(sum < TARGET) {
//				++e;
//				sum += arr[e-1];
//			}
//			else {
//				if(sum == TARGET) {ans++;}
//				sum -= arr[s];
//				s++;
//			}
//		}
		
		System.out.println(ans);
	}
}
