package com.ssafy.adpcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NPTest {
	
	static int N;
	static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 사전식 순열 생성하기 위해 오름차순 정렬
		Arrays.sort(numbers);
		
		do {
			System.out.println(Arrays.toString(numbers));
		}while(np(numbers));
	}
	
	static boolean np(int[] numbers) { // 다음 순열 존재 true, 아니면 false 리턴
		
		// step1. 꼭대기 위치 찾기
		final int N = numbers.length;
		int i = N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) --i;
		
		if(i==0) return false; // 현 순열의 상태가 가장 큰 순열의 상태
		
		
		// step2. 꼭대기 바로 앞 위치와 교환 할 큰 수 찾기
		
		
		// step3. 꼭대기 바로 앞 위치의 수와 큰수 교환
		
		
		// step4. 꼭대기부터 맨 마지막 위치까지의 값들 오름차순 정렬
		
		
	}
}
