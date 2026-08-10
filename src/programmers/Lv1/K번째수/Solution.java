package programmers.Lv1.K번째수;

import java.util.Arrays;

public class Solution {
	
	public static int[] solution2(int[] array, int[][] commands) {
		int[] result = new int[commands.length];
		for (int idx = 0; idx < commands.length; idx++) {
			int i = commands[idx][0];
			int j = commands[idx][1];
			int k = commands[idx][2];
			
			int[] subArray = Arrays.copyOfRange(array, i-1, j);
			
			Arrays.sort(subArray);
			
			result[idx] = subArray[k-1];
		}
		return result;
	}
	
	public static int[] solution1(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
    	for (int idx = 0; idx < commands.length; idx++) {
			int i = commands[idx][0];
			int j = commands[idx][1];
			int k = commands[idx][2];
			
			int[] sub_array = new int[j-i+1];
			int in = 0;
			for (int l = i-1; l < j; l++) {
				sub_array[in++] = array[l];
			}
			for (int l = 0; l < sub_array.length-1; l++) {
				for (int l2 = l+1; l2 < sub_array.length; l2++) {
					if(sub_array[l] > sub_array[l2]) {
						int tmp = sub_array[l];
						sub_array[l] = sub_array[l2];
						sub_array[l2] = tmp;
					}
				}
			}
			result[idx] = sub_array[k-1];
		}
    	return result;
    }
    public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
//		int[] result = solution1(array, commands);
		int[] result = solution2(array, commands);		
		for (int n : result) {
			System.out.println(n);
		}
	}
}