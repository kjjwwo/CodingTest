package programmers.Lv1.신규아이디추천;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static String solution2(String new_id) {
		
		String s = new KAKAOID(new_id)
				.replaceToLowerCase()
				.filter()
				.toSingleDot()
				.noStartEndDot()
				.noBlank()
				.trancateTo15()
				.padTo3()
				.getResult();
		
		return s;
	}
	
	private static class KAKAOID{
		private String s;
		
		KAKAOID(String s){
			this.s = s;
		}
		
		private KAKAOID replaceToLowerCase() {
			s = s.toLowerCase();
			return this;
		}
		
		private KAKAOID filter() {
			s = s.replaceAll("[^a-z0-9-_.]", "");
			return this;
		}
		
		private KAKAOID toSingleDot() {
			s = s.replaceAll("\\.{2,}",".");
			return this;
		}
		
		private KAKAOID noStartEndDot() {
			s = s.replaceAll("^\\.||\\.$", "");
			return this;
		}
		
		private KAKAOID noBlank() {
			s = s.isEmpty() ? "a" : s;
			return this;
		}
		
		private KAKAOID trancateTo15() {
			if (s.length() > 15) {
				s = s.substring(0, 15);
			}
			s = s.replaceAll("[.]$", "");
			return this;
		}
		
		private KAKAOID padTo3() {
			StringBuilder sb = new StringBuilder(s);
			while(sb.length() < 3) {
				sb.append(sb.charAt(sb.length() -1));
			}
			s = sb.toString();
			return this;
		}
		
		private String getResult() {
			return s;
		}
	}
	
    public static String solution1(String new_id) {
    	
    	StringBuilder sb = new StringBuilder();
        
    	// #1
    	new_id = new_id.toLowerCase();
    	
        // #2 & 3
    	for (int i = 0; i < new_id.length(); i++) {
			char tmp = new_id.charAt(i);
			
			if (Character.isAlphabetic(tmp) || Character.isDigit(tmp)
					|| tmp == '-' || tmp == '_') {		
				sb.append(tmp);
			}
			
			else if (tmp == '.') {
				if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '.') {
					sb.append(tmp);
				}
			}
		}
    	
        new_id = sb.toString();
        
    	// #4
        if (!new_id.isEmpty() && new_id.charAt(0) == '.') {
        	new_id = new_id.substring(1);
        }
        
        if (!new_id.isEmpty() && new_id.charAt(new_id.length()-1) == '.') {
        	new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // #5
        if (new_id.isEmpty()) {
        	new_id = "a";
        }
        
        // #6
        if (new_id.length() > 15) {
        	new_id = new_id.substring(0, 15);
        	if (new_id.charAt(new_id.length()-1) == '.') {
            	new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        
        // #7
        while (new_id.length() < 3) {
        	new_id += new_id.charAt(new_id.length() - 1);
        }
        
        return new_id;
    }
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(solution1(str));
		System.out.println(solution2(str));
	}
}
