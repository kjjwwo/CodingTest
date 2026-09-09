package programmers.Lv2.올바른괄호;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        
    	Stack<Character> stack = new Stack<Character>();
    	
    	for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == ')') {
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
    	
        return stack.isEmpty();
    }
}