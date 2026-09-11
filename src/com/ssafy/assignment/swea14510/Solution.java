package com.ssafy.assignment.swea14510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author JW
 * 나무 높이
 * 
 * N개 나무
 * 
 * 나무 높이 배열 들어옴
 * 
 * 첫 날은 1 자라고
 * 둘째 날은 2 자람 
 * 셋째 날은 다시 1 자람
 * 모든 나무의 키가 처음 가장 컸던 나무랑 똑같아 지려면 며칠 물을 줘야 함?
 * 물은 안줘도 됨
 * 
 * 제일 키가 큰거 maxTree
 * 
 * grow = maxTree - 나머지 : 각 나무 별 커야 할 높이
 * 
 * grow를 2*m+1 or 2*m 형태로 변환
 * 
 * 필요한 1의 갯수와 2의 갯수 구함
 * 
 * 1이랑 2랑 동일하면 (1혹은 2의 갯수)*2
 * 1이 2보다 많으면 (2의 갯수)*2 + (남은 1의 수) * 2
 * 2가 1보다 많으면 (1의 갯수)*2 + (남은 2의 수 * 4/3 + 나머지) 
 * 
 * 남은 2일 수 * 2 = 전체 남은 수
 * 전체 남은 수 / 3 * 2 = 1, 2로 채울 수 있는 수
 * 
 * 
 */


public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] trees = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int maxTree = 0;
			int days = 0;
			
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if(maxTree < trees[i]) {
					maxTree = trees[i];
				}
			}
			
			int one = 0;
			int two = 0;
			
			for (int i = 0; i < N; i++) {
				trees[i] = maxTree - trees[i];
				if(trees[i] % 2 == 1) {
					one++;
				}
				two += trees[i] / 2; 
			}
			
			if(one == two) {
				days = one * 2;
			}
			else if(one > two) {
				days = two * 2 + (one - two) * 2 - 1;
			}
			else {
				days = one * 2 + ((two - one) * 2) / 3 * 2 + ((two - one) * 2) % 3;
			}
			
			sb.append("#").append(tc).append(" ").append(days).append("\n");
		}
		System.out.print(sb.toString());
	}
}
