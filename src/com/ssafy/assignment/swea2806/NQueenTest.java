package com.ssafy.assignment.swea2806;

import java.util.Scanner;

public class NQueenTest {
	
	static int N, cnt;
	static boolean[] col, mainDiagonal, subDiagonal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 맵의 크기
		cnt = 0;
		
		col = new boolean[N+1]; // 첫행을 1로
		mainDiagonal = new boolean[2*N+1]; // 주 대각선은 차가 일정. 그냥 밑에랑 똑같이 맞춰줌 
		subDiagonal = new boolean[2*N+1]; // 부 대각선은 합이 일정. 1+1=2부터 시작이라서, 2*N (+1)
		
		setQueen(1);
		System.out.println(cnt);
		
	}
	
	static void setQueen(int row) {
		
		if(row > N) {
			// 놓아진 퀸들이 양립가능하다면 답
			++cnt;
			return;
		}
		
		// 1열부터 N열 시도
		for (int c = 1; c <= N; c++) {
			if(!isAvailable(row, c)) continue; // 가지치기
			col[c] = mainDiagonal[(row-c)+N] = subDiagonal[row+c] = true;
			setQueen(row+1);
			col[c] = mainDiagonal[(row-c)+N] = subDiagonal[row+c] = false;
		}
	}
	
	static boolean isAvailable(int r, int c) {
		return !col[c] && !mainDiagonal[(r-c)+N] && !subDiagonal[r+c];
	}
}
