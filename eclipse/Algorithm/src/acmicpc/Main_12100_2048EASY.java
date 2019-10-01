package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2019년 9월 29일  23:04 시작

public class Main_12100_2048EASY {
	private static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] board = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] ttmp = new int[N][N];
		for (int i = 0; i < 4; i++) {
			for (int i2 = 0; i2 < ttmp.length; i2++) {
				for (int j2 = 0; j2 < ttmp.length; j2++) {
					ttmp[i2][j2] = board[i2][j2];
				}
			}
			moving(board, i);
			process(board, 1);
			for (int i2 = 0; i2 < ttmp.length; i2++) {
				for (int j2 = 0; j2 < ttmp.length; j2++) {
					board[i2][j2] = ttmp[i2][j2];
				}
			}
		}
		System.out.println(max);
	}// end of main


	private static void process(int[][] board, int depth) {

		if (depth == 5) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					max = max > board[i][j] ? max : board[i][j];
				}
			}
			return;
		}

		int[][] tmp = new int[board.length][board.length];


		for (int i = 0; i < 4; i++) {
			for (int i2 = 0; i2 < tmp.length; i2++)
				for (int j2 = 0; j2 < tmp.length; j2++)
					tmp[i2][j2] = board[i2][j2];
			moving(board,i);
			process(board, depth+1);
			for (int i2 = 0; i2 < tmp.length; i2++) {
				for (int j2 = 0; j2 < tmp.length; j2++) {
					board[i2][j2] = tmp[i2][j2];
				}
			}
		}
		
		

	}

	private static void moving(int[][] board, int dir) {
		int[][] temp = new int[board.length][board.length];
		int[] idx = new int[board.length];
		boolean[][] chk = new boolean[board.length][board.length];
		switch (dir) {
		case 0:
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp.length; j++) {
					if(board[i][j] != 0) {
						temp[i][idx[i]] = board[i][j];
						if(idx[i] != 0 && temp[i][idx[i]] == temp[i][idx[i]-1] && !chk[i][idx[i]-1]) {
							chk[i][idx[i]-1] = true;
							temp[i][idx[i]-1] = temp[i][idx[i]-1]*2;
							temp[i][idx[i]] = 0;
						}
						else {
							idx[i]++;
						}
					}
				}
			}
			for (int i = 0; i < idx.length; i++) {
				for (int j = 0; j < idx.length; j++) {
					board[i][j] = temp[i][j];
				}
			}
			break;

		case 1:
			for (int i = 0; i < temp.length; i++) {
				for (int j = temp.length-1; j >= 0; j--) {
					if(board[i][j] != 0) {
						temp[i][temp.length-idx[i]-1] = board[i][j];
						if(idx[i] != 0 && temp[i][temp.length-idx[i]-1] == temp[i][temp.length-idx[i]] && !chk[i][temp.length-idx[i]]) {
							chk[i][temp.length-idx[i]] = true;
							temp[i][temp.length-idx[i]] = temp[i][temp.length-idx[i]]*2;
							temp[i][temp.length-idx[i]-1] = 0;
						}
						else {
							idx[i]++;
						}
					}
				}
			}
			for (int i = 0; i < idx.length; i++) {
				for (int j = 0; j < idx.length; j++) {
					board[i][j] = temp[i][j];
				}
			}
			break;

		case 2:
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp.length; j++) {
					if(board[j][i] != 0) {
						temp[idx[i]][i] = board[j][i];
						if(idx[i] != 0 && temp[idx[i]][i] == temp[idx[i]-1][i] && !chk[idx[i]-1][i]) {
							chk[idx[i]-1][i] = true;
							temp[idx[i]-1][i] = temp[idx[i]-1][i]*2;
							temp[idx[i]][i] = 0;
						}
						else {
							idx[i]++;
						}
					}
				}
			}
			for (int i = 0; i < idx.length; i++) {
				for (int j = 0; j < idx.length; j++) {
					board[i][j] = temp[i][j];
				}
			}
			break;

		case 3:
			for (int i = 0; i < temp.length; i++) {
				for (int j = temp.length-1; j >= 0; j--) {
					if(board[j][i] != 0) {
						temp[temp.length-idx[i]-1][i] = board[j][i];
						if(idx[i] != 0 && temp[temp.length-idx[i]-1][i] == temp[temp.length-idx[i]][i] && !chk[temp.length-idx[i]][i]) {
							chk[temp.length-idx[i]][i] = true;
							temp[temp.length-idx[i]][i] = temp[temp.length-idx[i]][i]*2;
							temp[temp.length-idx[i]-1][i] = 0;
						}
						else {
							idx[i]++;
						}
					}
				}
			}
			for (int i = 0; i < idx.length; i++) {
				for (int j = 0; j < idx.length; j++) {
					board[i][j] = temp[i][j];
				}
			}
			break;
		}
	}
}// end of class
