package programmers.Lv1.공원산책;

public class SolutionReview {
	public static int[] solution(String[] park, String[] routes){
		int H = park.length;
		int W = park[0].length();
		
		int r = 0;
		int c = 0;
		
		// 시작 위치 탐색
		for (int i = 0; i < H; i++) {
			int idx = park[i].indexOf('S');
			
			if (idx != -1) {
				r = i;
				c = idx;
				break;
			}
		}
		
		for (int i = 0; i < routes.length; i++) {
			char direct = routes[i].charAt(0);
			int distance = routes[i].charAt(2) - '0';
			
			int dr = 0;
			int dc = 0;
			
			switch(direct) {
				case 'N'-> dr = -1;
				case 'S'-> dr = 1;
				case 'W'-> dc = -1;
				case 'E'-> dc = 1;
			}
			
			int nr = r;
			int nc = c;
			
			boolean canMove = true;
			
			for (int j = 0; j < distance; j++) {
				nr += dr;
				nc += dc;
				
				if (nr >= H || nr < 0 || nc >= W || nc < 0) {
					canMove = false;
					break;
				}
				if (park[nr].charAt(nc) == 'X') {
					canMove = false;
					break;
				}
			}
			if (canMove) {
				r = nr;
				c = nc;
			}
		}
		
		return new int[]{r, c};
	}
	
    public static void main(String[] args) {
		String[] park = {"SOO","OOO","OOO"};
		String[] routes = {"E 2","S 2","W 1"};	
    	int[] ans = solution(park, routes);
    	System.out.println(ans[0] + ", " + ans[1]);
	}
}
