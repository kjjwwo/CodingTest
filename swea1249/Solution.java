package codingtest.swea1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author JW
 *
 * 1249 - 보급로
 * BFS로 풀거임
 * 
 * 입력을 받아서, 2차원 배열 형태로 저장(map)
 * 
 * 상하좌우 이동 
 * dr = {-1,1,0,0};
 * dc = {0,0,-1,1};
 * 
 * 4가지 방향으로 이동할 거임
 * 
 * Queue를 만들어서 관리 
 * visited = {(0,0)}; 
 * -> {(1,0),(0,1)};
 * -> {(0,1),(2,0),(1,1)}
 * -> {(2,0),(1,1),(1,1),(0,2)}
 * -> {...}
 * 
 * 
 * 00900000
 * 90009990
 * 99999990
 * 99999990
 * 
 * 위로도 올라가야 함. 내가 왔던 방향 빼고 모두 탐색!
 * 
 * 그럼 왔던 방향 저장 필요, int[3]하고 마지막 인덴스는 왔던 방향 저장
 * 쭉 탐색
 */

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			StringTokenizer st;
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<int[]> visited = new LinkedList<int[]>();
//			visited.add({0,0});
//			while(!visited.isEmpty())
		}
	}
}
