package programmers;

public class t4 {
	public static void main(String[] args) {
		int t1 = 2;
		int t2 = 4;
		int t3 = 1;
		
		int a = solution(t1);
		int b = solution(t2);
		int c = solution(t3);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int answer = 0;
	static int[][] map = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,0},{20,21,22,23,24,25,26,0,0,0}};
	
	static int solution(int T) {
		answer = 0;
		int start = 17;
		int x = 1;
		int y = 6;
		dfs(T, x, y, 0);
		
        return answer;
    }

	private static void dfs(int T, int x, int y, int t) {
		if(t == T) {
			if(map[x][y] == 17)
				answer++;
			return;
		}
		
		int a = T-t;
		int b = Math.abs(x-1) + Math.abs(y-6);
		
		if(a < b ) {
			return;
		}
		
		
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			if(nx < 0 || ny < 0 || nx >= 3 || ny >= 10 || map[nx][ny] == 0)
				continue;
			
			dfs(T,nx,ny, t+1);
		}
	}
}
