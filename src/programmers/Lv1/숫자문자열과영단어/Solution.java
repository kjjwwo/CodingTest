package programmers.Lv1.숫자문자열과영단어;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String s) {
        
    	String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    	
    	for (int i = 0; i < number.length; i++) {
			s.replace(number[i], Integer.toString(i));
		}
    	
    	return Integer.parseInt(s);
    	
    	/**
    	Map<String, Integer> str2num = new HashMap<>();
    	
    	str2num.put("zero", 0);
    	str2num.put("one", 1);
    	str2num.put("two", 2);
    	str2num.put("three", 3);
    	str2num.put("four", 4);
    	str2num.put("five", 5);
    	str2num.put("six", 6);
    	str2num.put("seven", 7);
    	str2num.put("eight", 8);
    	str2num.put("nine", 9);
    	
    	String tmp = "";
    	int number = 0;
    	for (int i = 0; i < s.length(); i++) {
			
    		char cur = s.charAt(i);
    		
    		if (Character.isDigit(cur)) {
    			number = number * 10 + (cur - '0');
    			continue;
    		}
    		
			tmp = tmp + cur;
			
			if (str2num.containsKey(tmp)) {
				number = number * 10 + str2num.get(tmp);
				tmp = "";
			}
		}
    	return number;
    	*/
    }
}
