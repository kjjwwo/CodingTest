package com.ssafy.assignment.swea6782;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author JW
 * 
 * 6782.현주(이상함)가 좋아하는 제곱근 놀이
 * 
 * 2이상의 정수 N (2 <= N <= 10^12) 1조....? 1_000_000_000_000
 * 10^3^4 ~ 2^10^4=2^40... 단위가 미쳤음.. 2의 40승, 1조까지 가능
 * 
 * 
 * N에 할 수 있는 행동 2가지
 * 1. N = N+1;
 * 2. N = Math.sqrt(N); 단 Math.sqrt(N)은 정수
 * N이 2가 될 때까지 반복
 * 이때 행동을 최소로 한다면 몇 번만에 가능?
 * 
 * 1.Math.sqrt() // 이건 double 형태로 값 전달해줌 round한 값과 원래 값인 동일한지 판단 후 비교?
 * 1-1. 분기 필요 sqrt == (long) sqrt 이면, 그냥 cnt++하고 N = sqrt임
 * 			이게 아니면 다음 값 계산 필요.
 * 1-2. 현재 값을 sqrt 진행. 그걸 올림함. 
 * 1-3. 올림한 값 제곱에서 현재값 빼서 cnt에 더함
 * 1-4. 올림한 값을 또 sqrt하고 또 올림 및 제곱
 * 
 * 만일 N이 1조까지 가능하다면, 루트 N은 몇까지 가능? 10^6 = 1_000_000 백만
 * 
 * binary tree
 * parametric search 사용!!!
 * 2. left, right 수를 정하고 mid를 구해서 이진 탐색 진행!!
 * while(left <= right)
 * 		mid = (left + right) / 2
 * 		squred = mid * mid
 * 		if(N <= squared): answer = mid, right = mid-1 // mid까지 확인했으니 한칸 앞으로 이동!
 *		else : left = mid+1 // mid까지 확인했으니 한칸 뒤로 이동!
 * return = answer
 * 
 */

public class Solution {
	private static long cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 분기 필요 sqrt == (long) sqrt 이면, 그냥 cnt++하고 N = sqrt임
		// 		  이게 아니면 다음 값 계산 필요.
		// 현재 값을 sqrt 진행. 그걸 올림함. 
		// 올림한 값 제곱에서 현재값 빼서 cnt에 더함
		// 올림한 값을 또 sqrt하고 또 올림 및 제곱
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			long N = Long.parseLong(br.readLine());
			cnt = 0;
			
			// 1. Math.sqrt() 사용
//			while(N != 2) {
//				double sqrtDouble = Math.sqrt(N);
//				if(Math.round(sqrtDouble) == sqrtDouble ) {
//					N = (long) sqrtDouble;
//					cnt++;
//					continue;
//				}
//				
//				long sqrt = (long) Math.sqrt(N);
//				long sqrtSquared = (sqrt + 1) * (sqrt + 1);
//				cnt += (sqrtSquared - N);
//				N = sqrt + 1;
//				cnt++;
//			}
			
			// 2. Parametric search 사용
			while(N != 2) {
				long sqrt = parametricSearch(N);
				cnt += sqrt * sqrt - N;
				N = sqrt;
				cnt++;
			}
			
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	private static long parametricSearch(long n) {
		long left = 2;
		long right = 1_000_000L;
		long answer = 0;
		while(left <= right) {
			long mid = left + (right - left) / 2; // ㅐoverflow 위험이 있으니 이렇게!!!
			if(n <= mid * mid) {
				answer = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		return answer;
	}
	
	
}
 

