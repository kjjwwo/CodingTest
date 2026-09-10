package com.ssafy.assignment.swea1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * 상호의 배틀필드
 * 
 * 맵의 구성 요소를 배열에 담아둘까?
 * 2차원 배열에 맵을 입력 받음
 * 지시문도 배열로 담아둠
 * 
 * 지시문이 끝날 때까지 반복
 * 		지시문이 S면
 * 			현재 방향을 기준으로 직선 거리에 가장 가까운 * 혹은 #이 있는지 확인
 * 			만일 *이 제일 가깝다면 * -> .
 * 		지시문이 나머지면
 * 			명령한 방향에 해당하는 모습으로 변경
 * 			해당 방향 앞에 . 있다면 앞으로 전진
 * 
 * 방향에 따른 모습   
 * tank = {'^', 'v', '<', '>'}
 * 지형 지물 (안 쓸 수도 있음)
 * mapCom = {'.', '*', '#', '-'}
 * 
 * 방향 
 * dx = {0, 0, -1, 1}
 * dy = {-1, 1, 0, 0}
 * 
 * (예시 좌표)
 * [[0,0][0,1][0,2][0,3][0,4]]
 * [[1,0][1,1][1,2][1,3][1,4]]
 * [[2,0][2,1][2,2][2,3][2,4]]
 * [[3,0][3,1][3,2][3,3][3,4]]
 * 
 * 방향에 따른 지시문
 * instruct = {'U', 'D', 'L', 'R'}
 * 
 * 
 * 
 */

public class Solution {
	
	// 탱크
	static int[] tCoord;
	static char[] tank = {'^', 'v', '<', '>'};
	
	// 방향
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	// 지시문
	static char[] instruct = {'U', 'D', 'L', 'R'};
	
	// 지형 지물 (안 쓸 수도 있음)
//	static char[] mapCom = {'.', '*', '#', '-'}; // 평지, 벽돌, 강철, 물
	private static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// map 생성
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				String row = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = row.charAt(j);
				}
			}
			
			// 명령 모음 생성
			int N = Integer.parseInt(br.readLine());
			char[] instructs = new char[N];
			
			String strInst = br.readLine();
			for (int i = 0; i < N; i++) {
				instructs[i] = strInst.charAt(i);
			}
			
			// 탱크 위치 초기화
			tCoord = new int[2];
			
			for (int i = 0; i < H; i++) {
				boolean find = false;
				for (int j = 0; j < W; j++) {
					char c = map[i][j];
					if (c == '^' || c == 'v' || c == '<' || c == '>') {
						tCoord[0] = j;
						tCoord[1] = i;
						find = true;
						break;
					}
				}
				if (find) break;
			}
			
			// 명령 실행
			for (int i = 0; i < N; i++) {
				char in = instructs[i];
				// Shoot 명령이라면?
				if(in == 'S') {
					for (int j = 0; j < 4; j++) {
						int x = tCoord[0];
						int y = tCoord[1];
						if(map[y][x] == tank[j]) {
							x += dx[j];
							y += dy[j];
							while(x >= 0 && x < W && y >=0 && y < H) {
								// 벽돌인지 확인
								if(map[y][x] == '*') {
									map[y][x] = '.';
									break;
								}
								// 강철인지 확인
								else if(map[y][x] == '#') {
									break;
								}
								x += dx[j];
								y += dy[j];
							}
							// 맞는 방향 탱크 찾았으면 추가 탐색 종료
							break;
						}
					}
					continue;
				}
				
				// Move 명령이라면?
				for (int j = 0; j < 4; j++) {
					if(in == instruct[j]) {
						int x = tCoord[0];
						int y = tCoord[1];
						map[y][x] = tank[j];
						
						int x2 = x + dx[j];
						int y2 = y + dy[j];
						
						// 맵 바깥으로 나가는지 확인
						if(x2 < 0 || x2 >= W || y2 < 0 || y2 >= H) break;
						// 탱크가 이동 가능한지 확인
						if(map[y2][x2] == '.') {
							map[y2][x2] = map[y][x];
							map[y][x] = '.';
							// 이동 했으면 움직임 처리
							tCoord[0] = x2;
							tCoord[1] = y2;
						}
						break;
					}
				}
			}// end of 명령 실행
			
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
//			sb.append("\n"); // 보기 힘들어서 줄 바꿈 했는데 답은 줄바꿈 안해뒀네 ㄷㄷ 
			
		}//end of test_case
		System.out.print(sb.toString());
	}//end of main
}// end of class
