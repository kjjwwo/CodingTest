package com.ssafy.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoNumberTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		final int N = Integer.parseInt(st.nextToken());
		final int TARGET = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(arr); // 정렬 전처리
//		int l=0, r=N-1, ans = 0; // l : left(왼쪽에서 오른쪽), r : right(오른족에서 왼쪽)
//		
//		while(l<r) { // 탐색 조건 l<r
//			int sum = arr[l] + arr[r];
//			if(sum == TARGET) {
//				++ans;
//				++l;
//				--r;
//			}else if(sum < TARGET) { // 두 수의 합이 작으니 수를 크게 만들자
//				++l;
//			}else { // 두 수의 합이 크니 수를 작게 만들자
//				--r; 
//			}
//		}
		
		////////////////////////////////////////////////////////////
		boolean[] flag = new boolean[2000000];
		int ans = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = TARGET - a;
			if (flag[b]) {
				ans++;
			}else {
				flag[a] = true;
			}
		}
		
		System.out.println(ans);
	}
}
