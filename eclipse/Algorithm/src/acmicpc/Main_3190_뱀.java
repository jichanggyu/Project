package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3190_¹ì {
	// zero : up    one : right    two : down    three : left
	static int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int K = Integer.parseInt(br.readLine().trim());
		
		int[][] map = new int[N][N];
		map[0][0] = 1;
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			x--;
			y--;
			map[x][y] = 2; // 2 is apple
		}
		LinkedList<data> al = new LinkedList<>();
		K = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int sec = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			al.add(new data(sec, dir));
		}
		// complete input logic 
		
		// start logic gogo SSIng ~!~1
		
		LinkedList<moving> mal = new LinkedList<>();
		int direction = 1;
		mal.add(new moving(0, 0)); // start x axis and  y axis 
		int result_time = 0;
		// when the game end, print time...
		data change = al.pop();
		boolean tf = false;
		while(true) {
			moving tmp = mal.get(0);
			int x = tmp.x;
			int y = tmp.y;
			x = x + d[direction][0];
			y = y + d[direction][1];
			
			if( x < 0 || y < 0 || x >= N || y >= N || map[x][y] == 1) {
				result_time++;
				break;
			}
			
			if(map[x][y] == 0) {
				mal.addFirst(new moving(x, y));
				map[mal.get(0).x][mal.get(0).y] = 1; 
				map[mal.getLast().x][mal.getLast().y] = 0; 
				mal.removeLast();
			}
			
			else if(map[x][y] == 2) {
				mal.addFirst(new moving(x, y));
				map[mal.get(0).x][mal.get(0).y] = 1; 
				map[x][y] = 1;
			}
			
			// termination condition
			
			result_time++;
			
			// zero : up    one : right    two : down    three : left
			// change direction ..
			if(!tf && result_time == change.sec) {
				switch (direction) {
				case 0:
					direction = change.dir == 'D' ? 1 : 3;
					break;
				case 1:
					direction = change.dir == 'D' ? 2 : 0;
					break;
				case 2:
					direction = change.dir == 'D' ? 3 : 1;
					break;
				case 3:
					direction = change.dir == 'D' ? 0 : 2;
					break;
				}
				
				if(al.size() == 0) {
					tf = true;
				}
				else
					change = al.pop();
			}
		}// end of while
		
		
		System.out.println(result_time); // this is result!!!
	}// end of main
	static class data{
		int sec;
		char dir;
		public data(int sec, char dir) {
			this.sec = sec;
			this.dir = dir;
		}
	}
	
	static class moving{
		int x;
		int y;
		public moving(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}// end of class
