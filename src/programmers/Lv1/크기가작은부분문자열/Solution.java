package programmers.Lv1.크기가작은부분문자열;

public class Solution {
    public int solution(String t, String p) {
    	int cnt = 0;
    	int limit = t.length() - p.length() + 1;
        for (int i = 0; i < limit; i++) {
			String tmp = t.substring(i, i+p.length());
			if (tmp.compareTo(p) <= 0) {cnt++;}
		}
        return cnt;
    }
}
