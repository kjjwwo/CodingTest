package programmers.Lv1.공원산책;

public class Solution {
    public static int[] solution(String[] park, String[] routes) {
    	int N = park.length;
    	String[][] parkMap = new String[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		String [] tmp = new String[N];
			tmp = park[i].split("");
			parkMap[i] = tmp;
		}
    	
    	for (int i = 0; i < parkMap.length; i++) {
			
		}
    	
    	
    	int[] answer = {};
        return answer;
    }
    
    public static void main(String[] args) {
		String[] park = {"SOO","OOO","OOO"};
		String[] routes = {"E 2","S 2","W 1"};	
    	solution(park, routes);
	}
}
