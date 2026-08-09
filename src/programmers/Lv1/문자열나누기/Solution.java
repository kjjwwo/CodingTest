package programmers.Lv1.문자열나누기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
	public static int solution2(String s) {
		int cnt = 0;
		int i = 0;
		
		while(i < s.length()) {
			char first = s.charAt(i);
			
			int same = 0;
			int different = 0;
			
			while(i < s.length()) {
				if (s.charAt(i) == first) {
					same++;
				}else {
					different++;
				}
				
				i++;
				
				if (same == different) {
					break;
				}
			}
			
			cnt++;
		}
		return cnt;
	}
	
	public static int solution1(String s) {
    	
    	int cnt = 0;
        
    	for (int i = 0; i < s.length(); i++) {
			int fgroup = 1;
			int ogroup = 0;
        	char first = s.charAt(i);
        	
			while(fgroup != ogroup) {
				if (++i == s.length()) {break;}
				else {
					if (first == s.charAt(i)) {
						fgroup++;
					}
					else {
						ogroup++;
					}	
				}
			}
			cnt++;
		}
        return cnt;
    }	
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(solution1(str));
		System.out.println(solution2(str));
	}
}
