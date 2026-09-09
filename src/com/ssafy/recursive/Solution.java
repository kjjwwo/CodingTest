package com.ssafy.recursive;

/**
 * 재귀함수 구조
 * 반복문 => 재귀함수 (리턴값, 멤버변수, 매개변수)
 * 
 * 반복문 (true) cpu 만 사용, 재귀호출 (종료파트 없을 경우) StackOverflowError
 * 재귀호출은 몇번이나 가능할까? 2000번
 * 변수 없으면: 11416
 * 변수1 : 4379
 * 
 */


public class Solution {
	private static int val;
	
	public static void ff(int i) {
		double d = 3;
		if(false) {
			return;
		}
		System.out.println(i + "," + d);
		ff(i+1);
	}
	
	public static void main(String[] args) {
		ff(1);
		
		
		// 팩토리얼 5! = 120
		int x = 1; 
		for(int i = 5; i >= 1; i--) {
			x = x * i;
		}
		System.out.println("5! = " + x); // 반복문, 5! = 120
		System.out.println("5! = " + f1(5)); // 재귀함수, 5! = 120
		// 재귀함수 멤버변수, 5! = 120
		val = 1;
		f2(5);
		System.out.println("5! = " + val);
		// 매개변수
		f3(5,1); // 매개 변수를 활용하는 방법이 가장 빠름
		
		
//////////////////////////////////////////////////////////////		
		
		// 01234
		for (int i = 0; i < 5; i++) {
			System.out.print(i);
		}
		System.out.println();
		f4(0);
		
		// 98765
		for (int i = 9; i >= 5; i--) {
			System.out.print(i);
		}
		System.out.println();
		f5(9);
		
		// 1-10까지 합
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("(반복)1-10까지 합 : " + sum);
		System.out.println("(재귀/리턴)1-10까지 합 : " + f6(1)); // 재귀함수 리턴값
		val = 0;
		// 재귀함수  멤버변수
		f7(1);
		System.out.println("(재귀/멤버)1-10까지 합: " + val);
		f8(1,0); // 재귀함수, 매개변수
	} // end of main

	private static void f8(int i, int v) {
		if(i > 10) {
			System.out.println("(재귀/매개)1-10까지 합 : " + v);
			return;
		}
		f8(i+1, v+i);
	}

	private static void f7(int i) {
		if(i > 10) {
			return;
		}
		val += i;
		f7(i+1);
	}

	private static int f6(int i) {
		if(i > 10) {
			return 0;
		}
		return i + f6(i+1);
	}

	private static void f5(int i) {
		if(i < 5) {
			System.out.println();
			return;
		}
		System.out.print(i);
		f5(i-1);
	}

	private static void f4(int i) {
		if(i >= 5) {
			System.out.println();
			return;
		}
		System.out.print(i);
		f4(i+1);
	}

	private static void f3(int i, int v) {
		if(i < 1) {
			System.out.println("5! = " + v);
			return;
		}
		f3(i-1,v*i);
	}

	private static void f2(int i) {
		if(i < 1) {
			return;
		}
		val *= i;
		f2(i-1);
	}

	/** 재귀함수 리턴, 5! = 120 */
	private static int f1(int x) {
		if (x < 1) {
			return 1;
		}else {
			return x * f1(x-1);
		}
	}
	
//	public void f() {
//		if() { // 종료파트
//			
//		}else {// 재귀파트
//			f();
//		}
//	}
} // end of class




// 참고
// call stack에는 일반적으로 약 2000번의 함수가 쌓일 수 있다. 