// 풀다가 머리 아파서 못품 -> GPT 참고함. 배열 이동 관련해서 익숙해져야 함
package programmers.Lv1.공원산책;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static int[] startCoord = {0,0};
	private static int[] dc = {0,0,-1,1};
	private static int[] dr = {-1,1,0,0};
	private static String[][] parkMap;
	private static int H;
	private static int W;

	public static int[] solution(String[] park, String[] routes) {
    	H = park.length;
    	W = park[0].length();
    	parkMap = new String[H][W];
    	
    	for (int i = 0; i < H; i++) {
    		String [] tmp = new String[H];
			tmp = park[i].split("");
			for (int j = 0; j < W; j++) {
				parkMap[i][j] = tmp[j];
				if (tmp[j].equals("S")) {
					startCoord[0] = i;
					startCoord[1] = j;
				}
			}
		}
    	
    	for (int i = 0; i < routes.length; i++) {
			String[] route = routes[i].split(" ");
    		move(route[0], route[1]);
		}
    	
    	
    	int[] answer = {startCoord[0], startCoord[1]};
        return answer;
    }
	
	private static void move(String d, String num) {
		int idx = switch (d) {
			case "N" -> 0;
			case "S" -> 1;
			case "W" -> 2;
			case "E" -> 3;
			default -> 4;
		};
		
		int moveCnt = Integer.parseInt(num);
		int[] tmp = new int[2];
		tmp[0] = startCoord[0];
		tmp[1] = startCoord[1];
		for (int i = 1; i <= moveCnt; i++) {
			int r = startCoord[0] + dr[idx];
			int c = startCoord[1] + dc[idx];
			
			if (r >= H || r < 0 || c >= W || c < 0) {
				startCoord[0] = tmp[0];
				startCoord[1] = tmp[1];
				break;
			}
			else if (parkMap[r][c].equals("X")) {
				startCoord[0] = tmp[0];
				startCoord[1] = tmp[1];
				break;
			}
			else {
				startCoord[0] = r;
				startCoord[1] = c;
			}
		}
		
	}
    
    public static void main(String[] args) {
		String[] park = {"SOO","OXX","OOO"};
		String[] routes = {"E 2","S 2","W 1"};	
    	int[] ans = new int[2]; 
    	ans = solution(park, routes);
    	System.out.println(ans[0] + ", " + ans[1]);
	}
}
