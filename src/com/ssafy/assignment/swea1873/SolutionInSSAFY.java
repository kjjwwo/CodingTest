package com.ssafy.assignment.swea1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionInSSAFY {
	
	static int dr[] = {-1, 0, 1, 0}; // 이동 방향에 따른 델타
	static int dc[] = {0, 1, 0, -1}; 
	static final String TANK_SYMBOLS = "^>v<";
	static final String DIRS = "URDL";
	
	static int H, W, r, c ,dir;
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // H, W (2 <= H, W <= 20)
			W = Integer.parseInt(st.nextToken());
			map = new char[H][];
			r = c = dir = 0;
			for (int i = 0; i < H; ++i)
				map[i] = br.readLine().toCharArray();
			
			br.readLine();// 명령길이 N (0 <= N <= 100)
			char[] command = br.readLine().toCharArray();
			
			play(command);
			
			sb.append("#" + tc + " ");
			for (int i = 0; i < H; ++i) {
				for (int j = 0; j < W; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void play(char[] command) {
		LOOP: for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				//전차 초기 위치와 방향 확인
				dir = TANK_SYMBOLS.indexOf(map[i][j]);
				if(dir == -1) continue;
				
				r = i;
				c = j;
				break LOOP;
			}	
		}
		
		map[r][c] = '.'; // 전차자리 평지로
		for (char cm : command) {
			if(cm == 'S') 
				shoot(); // 포탄발사 : 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다. 
			else
				move(cm); // 방향전환 명령
		}		
		
		// 마지막 전차위치에 현재 전차 방향으로 셋팅
		map[r][c] = TANK_SYMBOLS.charAt(dir);
	}

	private static void shoot() {
		int nr = r;
		int nc = c;
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			if(!isInRange(nr, nc) || map[nr][nc] == '#') break; // 경계 벗어나거나 강철벽을 만나면 빠져나옴
			
			if(map[nr][nc] == '*') {
				map[nr][nc] = '.';
				break;
			}
		}
	}

	private static void move(char newDir) {
		
		dir = DIRS.indexOf(newDir);
		
		// 방향전환 후 다음1칸 위치 계산
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		// 경계를 벗어나지 않고 해당 방향 위치가 평지이면 이동
		if (!isInRange(nr, nc) || map[nr][nc] != '.') return;
		
		r = nr;
		c = nc;
	}

	private static boolean isInRange(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
	
	private static void printDebugMap(char cmd) {
		
		System.out.println("------------------------------");
		System.out.println("[명령어]: " + (cmd != ' '?cmd : "없음(초기상태)"));
		
		System.out.println("[전차 정보] 위치: (" + r + ", " + c + ") | 방향: " + DIRS.charAt(dir));
		
		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				// 현재 전차 위치에는 임시로 전차 심볼을 출력
				if(i == r && j == c) {
					System.out.print(TANK_SYMBOLS.charAt(dir));
				}else {
					System.out.print(map[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
}
