package com.ssafy.tree;

public class CompleteBinaryTest {
	public static void main(String[] args) {
		
		String names[] = {"홍길동1", "홍길동2", "홍길동3", "홍길동4", "홍길동5", "홍길동6", "홍길동7"};
		
		CompleteBinaryTree<String> tree = new CompleteBinaryTree<>(names.length);
		
		for (String name : names) {
			tree.add(name);
		}
		System.out.println("=bfs=====================");
		tree.bfs();
		System.out.println("=dfs=====================");
//		tree.dfsByPreOrder();
//		tree.dfsByInOrder();
		tree.dfsByPostOrder();
	}
}
