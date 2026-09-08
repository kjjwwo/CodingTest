package com.ssafy.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {
	
	private Object[] nodes;
	private int lastIndex; // 마지막 노드의 인덱스
	private final int SIZE; // 트리 크기
	
	public CompleteBinaryTree(int sIZE) {
		SIZE = sIZE;
		nodes = new Object[SIZE+1]; // root node : 1 index 사용
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(T e) {
		if(isFull()) return;
		nodes[++lastIndex] = e;
	}
	
	public void bfs0() {
		
		if(isEmpty()) return;
		
		Queue<Integer> queue = new ArrayDeque<>();	// 큐에 무엇을 저장할 것인가?
											 		// 큐: 탐색할 대상 관리, 탐색할 대상에 대한 정보들을 넣는다. 
		// step1. 탐색의 시작점 큐에 넣기
		queue.offer(1);
		
		// step2~~ : 큐에 탐색 대상이 있는 동안 반복하기
		while(!queue.isEmpty()) {
			// step2. 큐에서 탐색 대상 확인하기(꺼내기)
			int current = queue.poll();
			// step3. 탐색대상과 해야할 작업 처리하기
			System.out.println(nodes[current]);
			// step3-2. 탐색대상과 관계있는 다른 탐색 대상들 큐에 넣기
			// left child
			int child = current*2;
			if(child <= lastIndex) queue.offer(child);
			// right child
			if(child+1 <= lastIndex) queue.offer(child+1);
		}
	}
	
	public void bfs1() {
		
		if(isEmpty()) return;
		
		Queue<int[]> queue = new ArrayDeque<>();	// 큐에 무엇을 저장할 것인가?
		// 큐: 탐색할 대상 관리, 탐색할 대상에 대한 정보들을 넣는다. 
		// step1. 탐색의 시작점 큐에 넣기
		queue.offer(new int[] {1,0});	// {탐색할노드 번호, 너비} 
		
		// step2~~ : 큐에 탐색 대상이 있는 동안 반복하기
		while(!queue.isEmpty()) {
			// step2. 큐에서 탐색 대상 확인하기(꺼내기)
			int[] info = queue.poll();
			int current = info[0];
			int breadth = info[1]; // 너비
			// step3. 탐색대상과 해야할 작업 처리하기
			System.out.println(nodes[current]+":"+breadth);
			// step3-2. 탐색대상과 관계있는 다른 탐색 대상들 큐에 넣기
			// left child
			int child = current*2;
			if(child <= lastIndex) queue.offer(new int[] {child, breadth+1});
			// right child
			if(child+1 <= lastIndex) queue.offer(new int[] {child+1, breadth+1});
		}
	}
	
	public void bfs() {
		
		if(isEmpty()) return;
		
		Queue<Integer> queue = new ArrayDeque<>();	// 큐에 무엇을 저장할 것인가?
											 		// 큐: 탐색할 대상 관리, 탐색할 대상에 대한 정보들을 넣는다. 
		// step1. 탐색의 시작점 큐에 넣기
		queue.offer(1);
		
		// step2~~ : 큐에 탐색 대상이 있는 동안 반복하기
		int breadth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(--size>=0) {
				// step2. 큐에서 탐색 대상 확인하기(꺼내기)
				int current = queue.poll();
				// step3. 탐색대상과 해야할 작업 처리하기
				System.out.println(nodes[current]+" : "+breadth);
				// step3-2. 탐색대상과 관계있는 다른 탐색 대상들 큐에 넣기
				// left child
				int child = current*2;
				if(child <= lastIndex) queue.offer(child);
				// right child
				if(child+1 <= lastIndex) queue.offer(child+1);
			}
			++breadth;
		}
	}

	public void dfsByPreOrder() {
		if(isEmpty()) return;
		dfsByPreOrder(1);
	}
	private void dfsByPreOrder(int current) {
		// step3. 탐색대상과 해야할 작업 처리하기
		System.out.println(nodes[current]);
		// step3-2. 탐색대상과 관계있는 다른 탐색 대상들 큐에 넣기
		// left child
		int child = current*2;
		if(child <= lastIndex) dfsByPreOrder(child);
		// right child
		if(child+1 <= lastIndex) dfsByPreOrder(child+1);
	}
	
	public void dfsByInOrder() {
		if(isEmpty()) return;
		dfsByInOrder(1);
	}
	private void dfsByInOrder(int current) {
		// step3-2. 탐색대상과 관계있는 다른 탐색 대상들 큐에 넣기
		// left child
		int child = current*2;
		if(child <= lastIndex) dfsByInOrder(child);
		// step3. 탐색대상과 해야할 작업 처리하기
		System.out.println(nodes[current]);
		// right child
		if(child+1 <= lastIndex) dfsByInOrder(child+1);
	}
	
	public void dfsByPostOrder() {
		if(isEmpty()) return;
		dfsByPostOrder(1);
	}
	private void dfsByPostOrder(int current) {
		// step3-2. 탐색대상과 관계있는 다른 탐색 대상들 큐에 넣기
		// left child
		int child = current*2;
		if(child <= lastIndex) dfsByPostOrder(child);
		// right child
		if(child+1 <= lastIndex) dfsByPostOrder(child+1);
		// step3. 탐색대상과 해야할 작업 처리하기
		System.out.println(nodes[current]);
	}

}
