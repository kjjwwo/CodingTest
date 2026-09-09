package com.ssafy.adpcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// nPn
public class PermutationTest {
	
	static int N;
	static int[] input, numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0,0);
	}
	
	static void permutation(int cnt, int flag) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) { // i : 선택할 수의 인덱스
			if ((flag & 1 << i) != 0) continue; // i 위치의 비트가 켜있다. 그럼 사용 중인 수이니 패스
			
			numbers[cnt] = input[i];
			permutation(cnt+1, flag | 1 << i);
		}
	}

	
}
