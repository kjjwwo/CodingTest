package com.ssafy.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiceTest {
	
	static int[] numbers; // 선택된 수들 저장
	static int N, totalCnt; // 주사위 던진 횟수
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 던진 횟수
		int mode = Integer.parseInt(st.nextToken()); // 던지기 모드
		
		numbers = new int[N];
		totalCnt = 0;
		switch (mode) {
		case 1:
			dice1(0);
			break;
		case 2:
			isSelected = new boolean[7]; // 주사위 눈의 수가 선택되었는지 여부의 플래그 배열(0 빼고 사용)
			dice2(0);
			break;
		case 3:
			dice3(0,1);
			break;
		case 4:
			dice4(0,1);
			break;
		default:
			System.out.println("모드 값은 1-4 사이의 값이 되어야 합니다.");
			break;	
		}
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	
	// 주사위 던지기 1 : 중복 순열
	static void dice1(int cnt) {
		if(cnt == N) { // 모든 자리의 수를 다 채움
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 1-6 까지의 수 시도
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			// 다음자리수 뽑으러 가기!
			dice1(cnt+1);
		}
	}
	
	// 주사위 던지기 2 : 순열
	static void dice2(int cnt) { // cnt : 직전까지 뽑은 수의 개수, 채워진 자리수
		
		if(cnt == N) { // 모든 자리의 수를 다 채움
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 1-6 까지의 수 시도
		for (int i = 1; i <= 6; i++) {
			// 시도하는 i의 수가 기존 선택한 수들과 같은지 체크: 중복되면 다음수로 ... 
			if (isSelected[i]) continue;
			// 중복되지 않은 수이면 선택
			numbers[cnt] = i;
			isSelected[i] = true;
			// 다음자리수 뽑으러 가기!
			dice2(cnt+1);
			// 다음수 시도하기 위해 기존의 흔적들 지우기
			isSelected[i] = false;
		}
	}
	
	// 주사위 던지기 2 : 중복 조합
	static void dice3(int cnt, int start) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i); // 중복된 선택이 가능하므로 시작 번호가 i부터 시작 (이것만 다름!!!)
		}
		
	}
	
	// 주사위 던지기 2 : 조합
	static void dice4(int cnt, int start) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}
}
