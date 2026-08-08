package programmers.Lv1.문자열내p와y의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static boolean solution(String s) {

        int p = 0;
        int y = 0;
        
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'P' || c == 'p') {
				p++;
			}
			else if (c == 'Y' || c == 'y') {
				y++;
			}
		}
        return (p == y);
    }
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
    	
    	System.out.println(solution(s));
	}
}
