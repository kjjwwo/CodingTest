package com.ssafy.assignment.swea1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * day, month, 3month, year 따로 따로 저장
 * usePlan 배열로 저장
 * 
 * 가장 저렴한 이용 방법? min을 1년 이용권으로 시작
 * 
 * 모든 선택을 다 해보자. 완탐. 순열. 시간복잡도 체크, 53만
 * 조건이 들어감. 상식적인 부분은 그리디로 
 * if 한달 이용권 산텍 -> 그달은 1일 이용권, 3달 이용권, 1년 이용권을 중복으로 사용하지 않는다.
 * 
 * 한달엔 하나의 결제 방법만 사용
 * 
 * 12달을 4가지 경우의 수로 선택
 * 
 * 1년은 1가지 경우
 * 1 + 3^12 = 약 53만
 * 
 *  
 * 매월 선택
 * 		1일 이용권 -> 1일 * 사용일 수
 * 		1달 이용권 -> +1달로 넘어가
 * 		3달 이용권 -> +3달로 넘어가
 * 		1년 이용권 <- 시작
 * 모든 선택 중 최소값을 구하자
 * 		종료파트 최소값을 업데이트
 * 
 * 재귀함수로 가는 이유 => 구조가 간단, 가지치기 하기 좋다
 * 		재귀함수 유형 (리턴, 멤버변수, 매개변수) 매개변수 좋다
 * 			지금까지의 연산결과를 매개변수로 가지고 다님, 중복 연산을 줄임
 * 			가지치기 하기 좋다. 
 * 
 */

public class Solution {
	
	static int minVal;
	private static int valDay;
	private static int val1Month;
	private static int val3Month;
	private static int valYear;
	private static int[] use;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			valDay = Integer.parseInt(st.nextToken());
			val1Month = Integer.parseInt(st.nextToken());
			val3Month = Integer.parseInt(st.nextToken());
			valYear = Integer.parseInt(st.nextToken());			
			
			use = new int[13];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 12; i++) {
				use[i] = Integer.parseInt(st.nextToken());
			}
			
			minVal = valYear;
			permutation(1,0);
			
			sb.append("#").append(test_case).append(" ").append(minVal).append("\n");
		}// end of test_case
		System.out.println(sb.toString());
		
	}// end of main
	/** month 달의 이용권을 선택하자, val 이전까지 선택한 이용권 금액 */
	static void permutation(int month, int val) {
		// 가지치기
		if(minVal < val)return;
		// 종료 파트
		if(month > 12) {
			if(minVal > val) {
				minVal = val;
			}
			return;
		}
		// 재귀 파트
//		permutation(month+1, val+valDay*use[month]);
//		permutation(month+1, val+val1Month);
		permutation(month+1, val+Math.min(use[month]*valDay, val1Month));
		permutation(month+3, val+val3Month);
		
	}
	
}// end of class




