package programmers.Lv1.명예의전당1;

import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int k, int[] score) {
    	int[] answer = new int[score.length];
    	
    	PriorityQueue<Integer> record = new PriorityQueue<Integer>();
    	
    	for (int i = 0; i < score.length; i++) {
			record.add(score[i]);
			if (record.size() > k) {
				record.poll();
			}
			answer[i] = record.peek();
		}
    	
    	return answer;
    }
}
