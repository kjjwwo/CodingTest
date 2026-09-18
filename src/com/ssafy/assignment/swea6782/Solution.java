package com.ssafy.assignment.swea6782;

/**
 * 
 * @author JW
 * 
 * 현주(이상함)가 좋아하는 제곱근 놀이
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
 * Math.sqrt() // 이건 double 형태로 값 전달해줌 round한 값과 원래 값인 동일한지 판단 후 비교?
 * 
 * 
 * 만일 N이 1조까지 가능하다면, 루트 N은 몇까지 가능? 10^6 = 1_000_000 백만
 * 
 * 
 * 
 * 
 *
 */

public class Solution {
	public static void main(String[] args) {
		long num = 1_000_000_000_000L;
		long[] square = new long[1_000_000];
		for (int i = 0; i < 1_000_000; i++) {
			square[i] = i^2;
		}
		
		
		
	}
}
