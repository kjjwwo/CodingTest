package programmers.Lv1.자릿수더하기;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static int solution(int n) {
        int total = 0;
        
        while(n/10 != 0) {
        	total += n % 10;
        	n /= 10;
        }
        return total;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		System.out.println(solution(n));
	}
}
