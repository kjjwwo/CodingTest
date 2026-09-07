package com.ssafy.linkedlist;

import java.util.EmptyStackException;

public class Stack<E> implements IStack<E>{

	private Node<E> top = null;
	
	@Override
	public void push(E e) { // top으로 추가, 맨 앞쪽 삽입 알고리즘
		top = new Node<>(e, top);
	}

	@Override
	public E pop() { // top의 원소 삭제 후 반환
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		Node<E> popNode = top;
		E e = popNode.data;
		
		top = popNode.link;
		
		popNode.link = null;
		popNode.data = null;
		return e;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int res = 0;
		for(Node<E> temp = top; temp != null; temp = temp.link) {
			res++;
		}
		return res;
	}

	@Override
	public String toString() {
		return "Stack [top=" + top + "]";
	}
	
	
}
