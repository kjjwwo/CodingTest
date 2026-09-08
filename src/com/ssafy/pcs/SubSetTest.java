package com.ssafy.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSetTest {
	
	static int N; // 원소 수
	static int[] input; // 입력 받은 원소들
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		isSelected = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		generateSubset(0);
	}
	
	static void generateSubset(int idx) { // idx: 처리해야하는 원소의 인덱스
		
		if(idx == N) { // 모든 원소를 고려했다면
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i]?input[i]:"X")+"\t");
			}
			System.out.println();
			return;
		}
		
		// 해당 원소를 부분집합에 포함시키기
		isSelected[idx] = true;
		generateSubset(idx+1);
		
		// 해당 원소를 부분집합에 미포함시키기
		isSelected[idx] = false;
		generateSubset(idx+1);
	}
	
}