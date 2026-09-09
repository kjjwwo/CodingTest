package programmers.Lv1.바탕화면정리;

public class Solution {
    public int[] solution(String[] wallpaper) {
	    	int H = wallpaper.length;
	    	int W = wallpaper[0].length();
	    	
	    	int lux = H; 
	    	int luy = W;
	    	int rdx = 0;
	    	int rdy = 0;
	    	
	    	for (int i = 0; i < H; i++) {
	    		for (int j = 0; j < W; j++) {
					if (wallpaper[i].charAt(j) == '#') {
						lux = Math.min(lux, i);
						luy = Math.min(luy, j);
						rdx = Math.max(rdx, i+1);
						rdy = Math.max(rdy, j+1);
					}
				}
			}
	    	
	    	
	    	int[] answer = {lux, luy, rdx, rdy};
	        return answer;
    }
}
