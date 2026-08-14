package programmers.Lv2.더맵게;

public class Solution {
    
	private static int[] heap;
	private static int heapSize;
	
	public int solution(int[] scoville, int K) {
        heap = new int[scoville.length + 1];
        heapSize = 0;
        
        for (int i = 0; i < scoville.length; i++) {
        	pushHeap(scoville[i]);
		}
        
        int mix = 0;
        
        while(heap[1] < K) {
        	if (heapSize < 2) {
        		return -1;
        	}
        	
        	int first = popHeap();
        	int second = popHeap();
        	
        	int newMenu = first + second * 2;
        	
        	pushHeap(newMenu);
        	mix++;
        }
    	
        return mix;
    }
    
    private static void pushHeap(int value) {
    	heap[++heapSize] = value;
    	
    	int curIdx = heapSize;
    	
    	while (curIdx > 1) {
    		int parentIdx = curIdx / 2;
    		
    		if (heap[parentIdx] <= heap[curIdx]) {
    			break;
    		}
    		swap(parentIdx, curIdx);
    		curIdx = parentIdx;
    	}
    }
    
    
    private static int popHeap() {
    	int min = heap[1];
    	
    	heap[1] = heap[heapSize];
    	heapSize--;
    	
    	int curIdx = 1;
    	
    	while(curIdx * 2 <= heapSize) {
    		int childIdx = curIdx * 2;
    		
    		if (childIdx + 1 <= heapSize &&
    				heap[childIdx + 1] < heap[childIdx]) {
    			childIdx++;
    		}
    		
    		if (heap[curIdx] <= heap[childIdx]) {
    			break;
    		}
    		
    		swap(curIdx, childIdx);
    		curIdx = childIdx;
    	}
    	return min;
    }
    
    private static void swap(int a, int b) {
    	int tmp = heap[a];
    	heap[a] = heap[b];
    	heap[b] = tmp;
    }
    
}
