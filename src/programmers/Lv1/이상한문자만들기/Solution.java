package programmers.Lv1.이상한문자만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static String solution(String s) {
        
    	StringBuilder sb = new StringBuilder();
    	
    	int Upper = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (tmp == ' ') {
				Upper = 0;
			}
			else if (Upper++ % 2 == 0) {
				tmp = Character.toUpperCase(tmp);
			}
			else {
				tmp = Character.toLowerCase(tmp);
			}
			
    		sb.append(tmp);
		}
    	return sb.toString();
    }
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(solution(str));
	}
}
