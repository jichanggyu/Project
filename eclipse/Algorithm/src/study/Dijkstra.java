package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine().trim())-1;
		ArrayList<data>[] al = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			al[i] = new ArrayList<>();
		}
		
		int inf = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int input1 = Integer.parseInt(st.nextToken()) - 1;
			int input2 = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			al[input1].add(new data(input2, w));
		}
		int[] dis = new int[N];
		boolean[] chk = new boolean[N];
		for (int i = 0; i < N; i++)
			dis[i] = inf;
		dis[start] = 0;
		int min = Integer.MAX_VALUE;
		int idx = 0;
		int value = 0;
		int cnt = 0;
		while (true) {
			min = Integer.MAX_VALUE;
			// idx = min_value index
			for (int i = 0; i < N; i++) {
				if (min > dis[i] && !chk[i]) {
					idx = i;
					min = dis[i];
				}
			}
			value = dis[idx];
			chk[idx] = true;
			for (int i = 0; i < al[idx].size(); i++) {
				if (dis[al[idx].get(i).end] > value + al[idx].get(i).w) {
					dis[al[idx].get(i).end] = value + al[idx].get(i).w;
				}
			}
			cnt++;
			if (cnt == N) {
				break;
			}

		} // end of while

		for (int i = 0; i < N; i++) {
			if (dis[i] == inf)
				System.out.println("INF");
			else
				System.out.println(dis[i]);
		}
	}// end of main
	static class data{
		int end;
		int w;
		public data(int end, int w) {
			this.end = end;
			this.w = w;
		}
	}
}// end of class
