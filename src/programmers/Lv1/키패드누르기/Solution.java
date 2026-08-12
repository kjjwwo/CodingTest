package programmers.Lv1.키패드누르기;

public class Solution {
	public String solution(int[] numbers, String hand) {
		
        int[] lCoord = {3,0};
        int[] rCoord = {3,2};
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numbers.length; i++) {
			// Coordinate setting
        	int num = numbers[i];
        	int[] tCoord = new int[2];
        	if(num == 0) {
				tCoord[0] = 3;
				tCoord[1] = 1;
			}
        	else {
        		tCoord[0] = (num-1) / 3;
        		tCoord[1] = (num-1) % 3;
        	}
        	
        	// select L
        	if (num == 1 || num == 4 || num == 7) {
        		lCoord[0] = tCoord[0];
        		lCoord[1] = tCoord[1];
        		sb.append('L');
        	}
        	// select R
        	else if (num == 3 || num == 6 || num == 9) {
        		rCoord[0] = tCoord[0];
				rCoord[1] = tCoord[1];
				sb.append('R');
        	}
        	// Mid
        	else{
        		int ld = Math.abs(lCoord[0] - tCoord[0]) + Math.abs(lCoord[1] - tCoord[1]);
            	int rd = Math.abs(rCoord[0] - tCoord[0]) + Math.abs(rCoord[1] - tCoord[1]);
            	if (ld == rd ) {
            		if(hand.equals("right")) {
            			sb.append('R');
            			rCoord[0] = tCoord[0];
            			rCoord[1] = tCoord[1];
            		}else {
            			sb.append('L');
                		lCoord[0] = tCoord[0];
                		lCoord[1] = tCoord[1];
            		}
            	}else if(ld < rd) {
            		sb.append('L');
            		lCoord[0] = tCoord[0];
            		lCoord[1] = tCoord[1];
            	}else {
            		sb.append('R');
        			rCoord[0] = tCoord[0];
        			rCoord[1] = tCoord[1];
            	}	
        	}
        	
		}
        
    	String answer = sb.toString();
        return answer;
    }
	
}