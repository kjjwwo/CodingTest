package com.ssafy.assignment.swea2806;

/**
 * @author JW
 * 
 * N-Queen 문제
 * 
 * nxn 크기의 체스판
 * 
 * n개의 Queen이 서로 공격하지 못하도록 배치 -> 그 경우의 수는?
 * 
 * dfs 사용 - n개의 queen을 모두 배치해보고 다음 차례 다음 차례
 * + 가지치기를 통해 가짓수 줄이기
 * + 돌아가서 탐색하는 백트래킹
 * 이건 순열? 조합? 부분집합? 굳이 따지자면 순열?
 * 
 * n을 입력 받고
 * n x n boolean 배열 생성
 * boolean[n] board = new boolean[n][n]
 * 
 * existR = new boolean[n]
 * existC = new boolean[n]
 * 
 * board의 0,0 위치부터 queen을 하나씩 넣음
 * 이때 dfs 이용
 * 재귀적으로 생각한다면... 현재 칸을 보고, 들어갈 수 있으면 넣고 아니면 다음칸!
 * 
 * dfs(int r){ // row를 한칸씩 내려갈거라서 이렇게 
 * 		if(r == 9)return;
 * 		
 * 		for(i = 0; i < c; i++){
 * 			int r 있음? (existR[] visited와 유사)		
 * 			int c 있음? (existC[] visited와 유사)
 * 			둘다 없으면 대각선 확인 1. 왼쪽 대각선 위 확인 2. 오른쪽 대각선 위 확인 -> 최대 2n번
 * 			
 * 			모두 만족하면 board에 넣고
 * 			existR, existC 업데이트
 * 			dfs(cnt+1, r+1); 
 * 		}
 * }
 * 
 * 
 * 
 * 
 */


public class Solution {
	public static void main(String[] args) {
		
	}
}
