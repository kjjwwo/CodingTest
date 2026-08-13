package swea.d4.SWEA_1861;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] rooms = new int[N][N];
			
			// 방 생성
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[N][N];
			int[] dx = {0,0,-1,1};
			int[] dy = {1,-1,0,0};
			int max_room = 0;
			int max_start = N*N+1;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(dp[i][j] != 0) {
						continue;
					}
					
					int cnt = 1;
					int num = rooms[i][j];
					int x = i;
					int y = j;
					
					List<int[]> path = new ArrayList<>();
					
					boolean moved = false;
					while(true) {
						moved = false;
						for (int k = 0; k < 4; k++) {
							if ((x + dx[k] >= N) || (y + dy[k] >= N) || (x + dx[k] < 0) || (y + dy[k] < 0)){
								continue;
							}
							if (rooms[x + dx[k]][y + dy[k]] == (rooms[x][y]+1)) {
								x += dx[k];
								y += dy[k];
								if (dp[x][y] != 0) {
									cnt += dp[x][y];
									break;
								}else {
									int[] dxdy = {x,y};
									path.add(dxdy);
									cnt++;
									moved = true;
									break;
								}
							}
						}
						if(!moved) {
							dp[i][j] = cnt;
							int tmp = cnt;
							for (int k = 0; k < path.size(); k++) {
								dp[path.get(k)[0]][path.get(k)[1]] = --tmp;
							}
							break;	
						}
					}
					
					// if문 분기 헷갈려서 10분 잡아 먹음 ㄷㄷㄷㄷㄷ 미치겠다
					if (cnt > max_room) {
						max_room = cnt;
						max_start = num;
					}
					else if (cnt == max_room) {
						max_start = Math.min(max_start, num);
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(max_start).append(" ").append(max_room).append("\n");
			
/**			
			boolean[][] visited = new boolean[N][N];		
			int[] dx = {0,0,-1,1};
			int[] dy = {1,-1,0,0};
			int max_room = 0;
			int max_start = N*N+1;
			// 방 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j]) {
						continue;
					}
					
					// 방문 완료
					visited[i][j] = true;
					
					int cnt = 1;
					int num = rooms[i][j];
					int x = i;
					int y = j;
					
					boolean search = false;
					while(true) {
						search = false;
						for (int k = 0; k < 4; k++) {
							if ((x + dx[k] >= N) || (y + dy[k] >= N) || (x + dx[k] < 0) || (y + dy[k] < 0)){
								continue;
							}
							if (rooms[x + dx[k]][y + dy[k]] == (rooms[x][y]+1)) {
								x += dx[k];
								y += dy[k];
								visited[x][y] = true;
								cnt++;
								search = true;
								break;
							}
						}
						if(!search) {
							break;	
						}
					}
					
					// if문 분기 헷갈려서 10분 잡아 먹음 ㄷㄷㄷㄷㄷ 미치겠다
					if (cnt > max_room) {
						max_room = cnt;
						max_start = num;
					}
					else if (cnt == max_room) {
						max_start = Math.min(max_start, num);
					}
					
				}				
			}
			
			sb.append("#").append(test_case).append(" ").append(max_start).append(" ").append(max_room).append("\n");
			*/
		}
		System.out.println(sb.toString());
	}
}
