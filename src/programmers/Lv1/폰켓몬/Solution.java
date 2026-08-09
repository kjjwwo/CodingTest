package programmers.Lv1.폰켓몬;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int solution(int[] nums) {

    	Set<Integer> phoneketmon = new HashSet<Integer>();
    	
    	for (int i = 0; i < nums.length; i++) {
			phoneketmon.add(nums[i]);
		}
    	
    	return (phoneketmon.size() > (nums.length / 2)) ? nums.length / 2 : phoneketmon.size(); 
    	
    	/**
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
    	
    	int get = nums.length / 2;
    	int total = map.size();
    	if (total > get) {
    		return get;
    	}else {
    		return total;
    	}
    	*/
    }
}