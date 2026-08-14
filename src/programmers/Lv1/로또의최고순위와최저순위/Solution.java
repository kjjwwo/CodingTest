package programmers.Lv1.로또의최고순위와최저순위;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int min_correct = 0;
    	int max_correct = 0;
    	for (int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0) {
				max_correct++;
				continue;
			}
    		for (int j = 0; j < win_nums.length; j++) {
				if(lottos[i] == win_nums[j]) {
					min_correct++;
					max_correct++;
					break;
				}
			}
		}
    	int[] answer = {0,0};
        
    	answer[0] = grade(max_correct);
    	answer[1] = grade(min_correct);
    	
    	return answer;
    }
    private static int grade(int a) {
    	switch(a) {
			case 6:
				return 1;
			case 5:
				return 2;
			case 4:
				return 3;
			case 3:
				return 4;
			case 2: 
				return 5;
			default:
				return 6;
		}
    }
}
