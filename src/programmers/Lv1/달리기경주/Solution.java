package programmers.Lv1.달리기경주;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String[] solution2(String[] players, String[] callings) {
		
		Map<String, Integer> name2Grade = new HashMap<String, Integer>();
		
		for (int i = 0; i < players.length; i++) {
			name2Grade.put(players[i], i);
		}
		
		for (int i = 0; i < callings.length; i++) {
			int idx = name2Grade.get(callings[i]);
			String tmp = players[idx];
			players[idx] = players[idx-1];
			players[idx-1] = tmp;
			
			name2Grade.put(players[idx], idx);
			name2Grade.put(players[idx-1], idx-1);
		}
		
		return players;
	}
	
    public String[] solution(String[] players, String[] callings) {
        
    	Map<String, Integer>name2Grade = new HashMap<String, Integer>();
    	Map<Integer, String>grade2Name = new HashMap<Integer, String>();
    	
    	
    	for (int i = 0; i < players.length; i++) {
			name2Grade.put(players[i], i);
			grade2Name.put(i, players[i]);
		}
    	
    	for (int i = 0; i < callings.length; i++) {
    		String p1 = callings[i];
    		int score = name2Grade.get(p1);
    		String p2 = grade2Name.get(score-1);
    		
    		// 순위 변경
    		name2Grade.put(p1, score-1);
    		name2Grade.put(p2, score);
    		grade2Name.put(score-1, p1);
    		grade2Name.put(score, p2);
    	}
    	
    	String[] answer = new String[players.length];
    	for (int i = 0; i < answer.length; i++) {
			answer[i] = grade2Name.get(i);
		}
        return answer;
    }
    
}
