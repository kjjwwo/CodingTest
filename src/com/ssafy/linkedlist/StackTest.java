package com.ssafy.linkedlist;

public class StackTest {
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		stack.push("홍길동1");
		stack.push("홍길동2");
		stack.push("홍길동3");
		stack.push("홍길동4");
		stack.push("홍길동5");
		
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack);
		
	}
}
