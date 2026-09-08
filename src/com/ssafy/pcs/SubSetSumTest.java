package com.ssafy.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입력받은 수들의 일부를 선택해서 합이 TARGET이 되는 경우의 수 구하기
public class SubSetSumTest {
	
	static int N, TARGET, ans; // 원소 수
	static int[] input; // 입력 받은 원소들
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		TARGET = Integer.parseInt(br.readLine());
		input = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		generateSubset(0,0,0);
		System.out.println(ans);
	}
	
	static void generateSubset(int idx, int sum, int cnt) { // idx: 처리해야하는 원소의 인덱스, 선택된 원소들의 합
		
		if(idx == N) { // 모든 원소를 고려했다면
			if(cnt>0 && sum == TARGET) {
				++ans;
			}
			return;
		}
		
		// 해당 원소를 부분집합에 포함시키기
		generateSubset(idx+1, sum+input[idx], cnt+1);
		// 해당 원소를 부분집합에 미포함시키기
		generateSubset(idx+1, sum, cnt);
	}	
}