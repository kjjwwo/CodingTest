package programmers.Lv1.최소직사각형;

class Solution {
    public int solution(int[][] sizes) {
        
    	int max_w = 0;
    	int max_h = 0;
    	
    	int w = 0;
    	int h = 0;
    	
    	for (int i = 0; i < sizes.length; i++) {
    		if (sizes[i][0] > sizes[i][1]) {
    			w = sizes[i][0];
    			h = sizes[i][1];
    		}else {
    			w = sizes[i][1];
    			h = sizes[i][0];
    		}
    		max_w = Math.max(max_w, w);
    		max_h = Math.max(max_h, h);
		}
    	int answer = max_w * max_h;
        return answer;
    }
}