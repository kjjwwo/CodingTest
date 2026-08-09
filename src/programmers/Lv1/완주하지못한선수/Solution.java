package programmers.Lv1.완주하지못한선수;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    
	public String solution(String[] participant, String[] completion) {
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	
    	for (String name : participant) {
    		map.put(name, map.getOrDefault(name, 0) + 1);
    	}
    	
    	for (String name : completion) {
    		map.put(name, map.get(name) - 1);
    	}
    	
    	for (Map.Entry<String, Integer> entry : map.entrySet()) {
    		if (entry.getValue() > 0) {
    			return entry.getKey();
    		}
    	}
    	
    	return "";
    }
    
	
	/**
    public String solution(String[] participant, String[] completion) {
    	Arrays.sort(participant);
    	Arrays.sort(completion);
    	
    	for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i]){
				return participant[i];
			}
		}
    	
    	return participant[participant.length - 1];
    }
    */
}