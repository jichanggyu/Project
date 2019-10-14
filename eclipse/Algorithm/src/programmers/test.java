package programmers;

import java.util.PriorityQueue;

import javax.xml.crypto.Data;

import programmers.test.data;

public class test {
	public static void main(String[] args) {
		String[] t1 = { "ABCBA", "DABAG", "EBABH", "FAJAI", "AKLMA" };
		String[] t2 = { "ABCBA", "DABAG", "ENABH", "FAJAI", "AKLMO" };
		int re = solution(t1);
		int rr = solution(t2);

		System.out.println(re);
		System.out.println(rr);
	}

	public static int solution(String[] board) {
		int answer = 0;
		char[][] map = new char[board.length][board.length];
		int[][] dir = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
		int size = board.length;
		int[][] idx1 = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		PriorityQueue<data> pq = new PriorityQueue<data>();
		boolean chk[][] = new boolean[size][size];
		for (int i = 1; i < size - 1; i++) {
			for (int j = 1; j < size - 1; j++) {
				if (!chk[i][j]) {
					chk[i][j] = true;
					char v = map[i][j];
					int x = i;
					int y = j;
					int len = 1;
					boolean tf = false;
					int len1 = 1;
					while(true) {
						x++;
						y++;
						if (x >= size-1 || y >= size-1)
							break;
						if (map[x][y] != v)
							break;
						len1++;
					}
					idx1[i][j] = len1;
					x = i;
					y = j;
					while (true) {
						x++;
						y++;
						if (x >= size-1 || y >= size-1)
							break;
						if (map[x][y] != v)
							break;
						len++;
						tf = true;
						chk[x][y] = true;
						if (len % 2 == 0)
							idx1[x][y] = len1-len + 1;
						else
							idx1[x][y] = len1 - len;
						pq.offer(new data(x, y, idx1[i][j]));
					}
					if(tf) {
						pq.offer(new data(i,j,len1));
					}
					else {
						idx1[i][j] = 0;
					}
				}
			}
		}
		
		
		while (pq.size() != 0) {
			data tmp1 = pq.remove();
			int x = tmp1.x;
			int y = tmp1.y;
			char tmp = map[x][y];
			int x1 = x + dir[0][0];
			int y1 = y + dir[0][1];
			int x2 = x + dir[1][0];
			int y2 = y + dir[1][1];
			int x3 = x + dir[2][0];
			int y3 = y + dir[2][1];
			int x4 = x + dir[3][0];
			int y4 = y + dir[3][1];
			int tmpans = 0;
			if (map[x1][y1] == tmp && map[x2][y2] == tmp && map[x3][y3] == tmp && map[x4][y4] == tmp) {
				int len = 1;
				// run Checking size
				// 1 check
				while (true) {
					x1 += dir[0][0];
					y1 += dir[0][1];
					x2 += dir[1][0];
					y2 += dir[1][1];
					x3 += dir[2][0];
					y3 += dir[2][1];
					x4 += dir[3][0];
					y4 += dir[3][1];
					if (x1 < 0 || y1 < 0 || x1 >= size || y1 >= size)
						break;
					if (x2 < 0 || y2 < 0 || x2 >= size || y2 >= size)
						break;
					if (x3 < 0 || y3 < 0 || x3 >= size || y3 >= size)
						break;
					if (x4 < 0 || y4 < 0 || x4 >= size || y4 >= size)
						break;
					if (map[x1][y1] == tmp && map[x2][y2] == tmp && map[x3][y3] == tmp && map[x4][y4] == tmp) {
						len++;
						continue;
					}
					break;
				}

				tmpans = len;
				answer = tmpans > answer ? tmpans : answer;
			}
			if (tmpans == tmp1.value)
				return answer * 2 + 1;
		}
		if (answer == 0)
			return 0;
		else
			return answer * 2 + 1;
	}

	static class data implements Comparable<data> {
		int x;
		int y;
		int value;

		public data(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(data o) {
			if (this.value < o.value)
				return 1;
			else if (this.value > o.value)
				return -1;
			return 0;
		}
	}
}
