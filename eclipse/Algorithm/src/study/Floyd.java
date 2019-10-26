package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(i == j)
					map[i][j] = 0;
				else
					map[i][j] = 10000000;
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int input1 = Integer.parseInt(st.nextToken()) -1;
			int input2 = Integer.parseInt(st.nextToken()) -1;
			int w = Integer.parseInt(st.nextToken());
			
			map[input1][input2] = map[input1][input2] > w ? w : map[input1][input2];
		}// end of for
		
		for(int k = 0; k < N ; k++) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(map[i][k]+map[k][j] < map[i][j])
						map[i][j] = map[i][k]+map[k][j];
				}
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}// end of main
}// end of class
